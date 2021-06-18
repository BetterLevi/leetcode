package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wei.liang
 * @since 2021/6/15
 */
public class LeetCode_1897 {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> count = new HashMap<>();
        for (String str : words) {
            for (Character c : str.toCharArray()) {
                if (count.containsKey(c)) {
                    count.put(c, count.get(c) + 1);
                } else {
                    count.put(c, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() % words.length != 0) {
                return false;
            }
        }
        return true;
     }

    public static void main(String[] args) {
        LeetCode_1897 lc = new LeetCode_1897();
        String[] words = {"abc","aabc"};
        System.out.println(lc.makeEqual(words));
    }
}
