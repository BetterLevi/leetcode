package lc;

/**
 * @author wei.liang
 * @since 2021/2/23
 */
public class LeetCode_1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        for (int i = 0; i < grumpy.length; i++) {
            grumpy[i] = grumpy[i] == 1 ? 0 : 1;
        }
        int noAnger = 0;
        for (int i = 0; i < X; i++) {
            noAnger += customers[i];
        }
        int beforeAnger = 0;
        int afterAnger = 0;
        for (int i = X; i < customers.length; i++) {
            afterAnger += customers[i] * grumpy[i];
        }
        int sum = beforeAnger + noAnger + afterAnger;
        int j = X;
        while (j < customers.length) {
            beforeAnger += customers[j - X] * grumpy[j - X];
            afterAnger = afterAnger - customers[j] * grumpy[j];
            noAnger = noAnger - customers[j - X] + customers[j];
            sum = Math.max(sum, noAnger + beforeAnger + afterAnger);
            j++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] c = {1,0,1,2,1,1,7,5};
        int[] g = {0,1,0,1,0,1,0,1};
        LeetCode_1052 lc = new LeetCode_1052();
        lc.maxSatisfied(c, g, 3);
    }
}
