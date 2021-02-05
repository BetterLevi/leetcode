package lc;

/**
 * @author wei.liang
 * @since 2021/2/5
 */
public class LeetCode_1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int tmp = cost[j];
            while (maxCost >= tmp) {
                res = Math.max(res, j - i + 1);
                j++;
                if (j < s.length()) {
                    tmp += cost[j];
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public int equalSubstring1(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int res = 0;
        int sum = 0;
        int nextIndex = 0;
        for (int i = 0; i < s.length() && nextIndex < s.length(); i++) {
            boolean intoLoop = false;
            sum += cost[nextIndex];
            while (maxCost >= sum) {
                intoLoop = true;
                res = Math.max(res, nextIndex - i + 1);
                nextIndex++;
                if (nextIndex < s.length() && maxCost >= sum + cost[nextIndex]) {
                    sum += cost[nextIndex];
                } else {
                    break;
                }
            }
            if (!intoLoop) {
                nextIndex++;
            }
            sum -= cost[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_1208 lc = new LeetCode_1208();
        String s = "ujteygggjwxnfl";
        String t = "nstsenrzttikoy";
        lc.equalSubstring1(s, t, 43);
    }
}
