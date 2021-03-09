package lc;

/**
 * @author wei.liang
 * @since 2021/3/9
 */
public class LeetCode_1047 {
    public String removeDuplicates(String s) {
        if (s.length() == 0) {
            return s;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                String s1 = s.substring(0, i - 1);
                String s2 = s.substring(i + 1);
                s = s1 + s2;
                break;
            }
            if (i == s.length() - 1) {
                return s;
            }
        }
        return removeDuplicates(s);
    }

    public String removeDuplicates_ans(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }

    public static void main(String[] args) {
        LeetCode_1047 lc = new LeetCode_1047();
        lc.removeDuplicates("aaaaaaaa");
    }
}
