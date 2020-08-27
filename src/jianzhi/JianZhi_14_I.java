package jianzhi;

/**
 * @author Levi
 * @date 2020.8.24
 */
public class JianZhi_14_I {


    public int cuttingRope(int n) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, helper(n, i));
        }
        return max;
    }

    private int helper(int n, int len) {
        int res = 1;
        while (n > len) {
            res *= len;
            n = n - len;
        }
        return res * n;
    }

    public static void main(String[] args) {
        JianZhi_14_I l = new JianZhi_14_I();
        System.out.println(l.cuttingRope(8));
    }
}
