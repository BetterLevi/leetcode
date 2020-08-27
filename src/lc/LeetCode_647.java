package lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 回文子串
 * @author Levi
 * @date 2020.8.19
 */
public class LeetCode_647 {
    public int countSubstrings(String s) {
        int res = 0;
        Map<String, Boolean> memo = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                String tmp = s.substring(i, j);
                Boolean ps = memo.get(tmp);
                if (ps != null && ps) {
                    res++;
                } else {
                    boolean isP = isPalindrome(tmp);
                    memo.put(tmp, isP);
                    if (isP) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        char[] sc = str.toCharArray();
        while (i < j) {
            if (sc[i] != sc[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public int countSubstrings_bet(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            //子串长度为奇数
            res += help(s, i, i);
            //子串长度为偶数
            res += help(s, i, i + 1);
        }
        return res;
    }

    private int help(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
