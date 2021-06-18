package lc;

/**
 * @author wei.liang
 * @since 2021/6/18
 */
public class LeetCode_483 {

    public String smallestGoodBase_ans(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }


    public String smallestGoodBase(String n) {
        long y = Long.parseLong(n);
        int x = 2;
        while (x <= y) {
            if ((y - 1) % x != 0) {
                x++;
                continue;
            }
            long z = y - (y - 1) / x;
            if (-1 != getPow(z, x)) {
                return String.valueOf(x);
            }
            x++;
        }
        return "";
    }

    private int getPow(long pow, int base) {
        int minPow = 2;
        int maxPow = (int)Math.log(pow) + 1;
        while (minPow < maxPow) {
            int mid = (minPow + maxPow) / 2;
            if (Math.pow(base, mid) > pow) {
                maxPow = mid;
            } else if (Math.pow(base, mid) < pow) {
                minPow = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    private boolean canPow(long pow, int base) {
        while (pow != 1) {
            if (pow % base != 0) {
                return false;
            }
            pow /= base;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_483 lc = new LeetCode_483();
        lc.smallestGoodBase("4681");
    }

}
