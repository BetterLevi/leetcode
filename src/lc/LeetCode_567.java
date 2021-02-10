package lc;

import java.util.Arrays;

/**
 * 判断第一个字符串的排列之一是第二个字符串的子串
 * @author wei.liang
 * @since 2021/2/10
 */
public class LeetCode_567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int[] tmp = new int[26];
        char[] s2c = s2.toCharArray();
        for (int i = 0; i < s2.length(); i++) {
            if (i < s1.length()) {
                tmp[s2c[i] - 'a']++;
                continue;
            }
            if (Arrays.equals(count, tmp)) {
                return true;
            }
            tmp[s2c[i - s1.length()] - 'a']--;
            tmp[s2c[i] - 'a']++;
        }

        return Arrays.equals(count, tmp);
    }
}
