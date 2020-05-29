/**
 * @author Levi
 * @date 2020.5.28
 */
public class LeetCode_38 {
    public String countAndSay(int n) {
        String res = "1";
        if (1 == n) {
            return res;
        }
        for (int i = 2; i <= n; i++) {
            res = build(res);
        }
        return res;
    }

    public String build(String str) {
        int len = str.length();
        int p = 0;
        StringBuilder buffer = new StringBuilder();
        while (p < len) {
            int count = 0;
            char val = str.charAt(p);
            while (p < len && str.charAt(p) == val) {
                p++;
                count++;
            }
            buffer.append(count).append(val);
        }
        return buffer.toString();
    }
}
