package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wei.liang
 * @since 2021/2/27
 */
public class LeetCode_395 {
    public int longestSubstring(String s, int k) {
        int[] record = new int[s.length()];
        Map<Character, Integer> count = new HashMap<>();
        char[] sc = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(!count.containsKey(sc[i])) {
                count.put(sc[i], 1);
                record[i] = 1;
                continue;
            }
            count.put(sc[i], count.get(sc[i]) + 1);
            record[i] = count.get(sc[i]);
        }
        int start = 0;
        int res = 0;
        while(start < s.length()) {
            int last = start;
            if(record[start] >= k) {
                start++;
                continue;
            }
            int first = 0;
            for(int i = 0; i  < s.length(); i++) {
                if(last == 0) {
                    break;
                }
                if(sc[i] == sc[last - 1]) {
                    first = i;
                    break;
                }
            }
            res = Math.max(res, last - first + 1);
            start++;
        }
        return res;
    }

    public int longestSubstring_copy(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }

    public static void main(String[] args) {
        LeetCode_395 lc = new LeetCode_395();
        lc.longestSubstring("aaabb",3);
    }
}
