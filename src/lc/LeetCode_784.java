package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wei.liang
 * @since 2021/6/23
 */
public class LeetCode_784 {

    public List<String> letterCasePermutation(String s) {
        char[] sc = s.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (sc[i] > 64 && sc[i] < 91) {
                res.add(s);
                res.add(s.replaceFirst(String.valueOf(sc[i]), String.valueOf(sc[i]).toLowerCase()));
            }
            if (sc[i] > 96 && sc[i] < 123) {
                res.add(s);
                res.add(s.replaceFirst(String.valueOf(sc[i]), String.valueOf(sc[i]).toUpperCase()));
            }
        }
        if (res.size() == 0) {
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println('A' > 87);
    }

    public void backTracking(String s, List<String> res) {

    }
}
