package lc;

/**
 * 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author wei.liang
 * @since 2021/3/15
 */
public class LeetCode_5701 {
    public boolean areAlmostEqual(String s1, String s2) {
        int i = 0;
        int j = 0;
        int num = 0;
        for (int k = 0; k < s1.length(); k++) {
            if (s1.charAt(k) != s2.charAt(k)) {
                if (num == 0) {
                    i = k;
                } else {
                    j = k;
                }
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}
