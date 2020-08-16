package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 计数二进制字符串
 *
 * @author Levi
 * @date 2020.8.10
 */
public class LeetCode_696 {

    public int countBinarySubstrings_bet(String s) {
        int cur = 1, pre = 0, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, pre);
    }
    public int countBinarySubstrings(String s) {
        Map<String, Boolean> memo = new HashMap<>();
        int res = 0;
        int subStrLen = 2;
        while (subStrLen <= s.length()) {
            for (int i = 0; i + subStrLen <= s.length(); i++) {
                String tmp = s.substring(i, i + subStrLen);
                if (memo.get(tmp) != null) {
                    if (memo.get(tmp)) {
                        res++;
                    }
                } else {
                    boolean t;
                    if (t = isCorrectStr(tmp)) {
                        res++;
                        memo.put(tmp, t);
                    }
                }
            }
            subStrLen = subStrLen + 2;
        }
        return res;
    }

    private boolean isCorrectStr(String str) {
        char[] sc = str.toCharArray();
        char half = sc[0] == '0' ? '1' : '0';
        String preHalf = str.substring(0, str.length() / 2);
        String rearHalf = str.substring(str.length() / 2, str.length());
        return !preHalf.contains(half + "") && !rearHalf.contains(sc[0] + "");
    }




}
