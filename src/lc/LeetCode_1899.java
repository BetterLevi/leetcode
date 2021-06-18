package lc;

/**
 * @author wei.liang
 * @since 2021/6/15
 */
public class LeetCode_1899 {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for (int[] tri : triplets) {
            if (tri[0] > target[0] || tri[1] > target[1] || tri[2] > target[2]) {
                tri[0] = -1;
            }
        }
        int[] res = new int[3];
        for (int[] tri : triplets) {
            if (tri[0] != -1) {
                res[0] = Math.max(res[0], tri[0]);
                res[1] = Math.max(res[1], tri[1]);
                res[2] = Math.max(res[2], tri[2]);
            }
        }
        return res[0] == target[0] && res[1] == target[1] && res[2] == target[2];
    }
}
