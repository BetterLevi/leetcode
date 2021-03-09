package SourceCode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Rate limiter implementation is based on token bucket algorithm. There are two parameters:
 * <ul>
 * <li>
 *     burst size - maximum number of requests allowed into the system as a burst
 *
 * </li>
 * <li>
 *     average rate - expected number of requests per second (RateLimiters using MINUTES is also supported)
 * </li>
 * </ul>
 *
 * @author Tomasz Bak
 */
public class RateLimiter {

    //分钟和秒与毫秒之间的转换率
    private final long rateToMsConversion;

    //已经被消费的令牌个数
    private final AtomicInteger consumedTokens = new AtomicInteger();

    //最后一次填充令牌桶的时间戳
    private final AtomicLong lastRefillTime = new AtomicLong(0);

    @Deprecated
    public RateLimiter() {
        this(TimeUnit.SECONDS);
    }

    public RateLimiter(TimeUnit averageRateUnit) {
        switch (averageRateUnit) {
            case SECONDS:
                //限流器单位为秒，则转换率为1000
                rateToMsConversion = 1000;
                break;
            case MINUTES:
                //限流器单位为分钟，则转换率为60*1000
                rateToMsConversion = 60 * 1000;
                break;
            default:
                throw new IllegalArgumentException("TimeUnit of " + averageRateUnit + " is not supported");
        }
    }

    public boolean acquire(int burstSize, long averageRate) {
        return acquire(burstSize, averageRate, System.currentTimeMillis());
    }

    public boolean acquire(int burstSize, long averageRate, long currentTimeMillis) {
        //当限流器获取令牌的最大值或速率小于等于0时，认为不进行限速
        if (burstSize <= 0 || averageRate <= 0) { // Instead of throwing exception, we just let all the traffic go
            return true;
        }
        //重新填充令牌
        refillToken(burstSize, averageRate, currentTimeMillis);
        return consumeToken(burstSize);
    }

    private void refillToken(int burstSize, long averageRate, long currentTimeMillis) {
        //上次填充令牌桶的时间戳
        long refillTime = lastRefillTime.get();
        //上次填充距离现在的时间段
        long timeDelta = currentTimeMillis - refillTime;
        //该时间段内需要填充的新的令牌个数（averageRate是恒定的令牌填充速率）
        long newTokens = timeDelta * averageRate / rateToMsConversion;
        //如果需要填充新令牌
        if (newTokens > 0) {
            //计算新的填充令牌的时间点
            long newRefillTime = refillTime == 0 //初次填充
                    ? currentTimeMillis
                    //计算当前时间，不直接使用currentTimeMills是防止不足以填充一个令牌的时长被吞
                    : refillTime + newTokens * rateToMsConversion / averageRate;
            //利用CAS机制保证只有一个线程可以将lastRefillTime更新成功
            if (lastRefillTime.compareAndSet(refillTime, newRefillTime)) {
                while (true) {
                    //当前已经消费的令牌个数
                    int currentLevel = consumedTokens.get();
                    //计算新的填充令牌后的已消耗的令牌数量， 如果此时 `burstSize` 更小，以它作为已消耗的令牌数量。
                    int adjustedLevel = Math.min(currentLevel, burstSize); // In case burstSize decreased
                    //令牌桶中剩余的令牌数量，最小为0
                    int newLevel = (int) Math.max(0, adjustedLevel - newTokens);
                    //通过 CAS 保证避免覆盖设置正在消费令牌的线程
                    if (consumedTokens.compareAndSet(currentLevel, newLevel)) {
                        return;
                    }
                }
            }
        }
    }

    private boolean consumeToken(int burstSize) {
        while (true) {
            int currentLevel = consumedTokens.get();
            //没有令牌
            if (currentLevel >= burstSize) {
                return false;
            }
            //通过 CAS 避免和正在消费令牌或者填充令牌的线程冲突
            if (consumedTokens.compareAndSet(currentLevel, currentLevel + 1)) {
                return true;
            }
        }
    }

    public void reset() {
        consumedTokens.set(0);
        lastRefillTime.set(0);
    }
}
