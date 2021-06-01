package lc;

/**
 * @author wei.liang
 * @since 2021/6/1
 */
public class LeetCode_1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        int minEat = 1;
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int maxEat = queries[i][2];
            int count = queries[i][1] + 1;
            int index = queries[i][0];
            long least = index != 0 ? sum[index - 1] + 1 : 1;
            long most = sum[index];
            res[i] = canReach(minEat, maxEat, count, least, most);
        }
        return res;
    }

    private boolean canReach(int minEat, int maxEat, int count, long least, long most) {
        return !(maxEat * count < least || minEat * count > most);
    }
}
