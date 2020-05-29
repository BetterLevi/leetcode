import java.util.ArrayList;
import java.util.List;

/**
 * KMP
 *
 * @author Levi
 * @date 2020.5.27
 */
public class LeetCode_28 {
    public int strStr(String haystack, String needle) {
        if("".equals(haystack) || haystack.length() < needle.length()) {
            return -1;
        }
        if("".equals(needle)) {
            return 0;
        }
        int i = 0;
        List<Integer> jump = getJump(needle);
        int jumpTime = jump.size();
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (i + needle.length() > haystack.length()) {
                    return -1;
                }
                String tmp = haystack.substring(i, i + needle.length());
                if (tmp.equals(needle)) {
                    return i;
                }
                i = jump.size() == 0 || j >= jumpTime || jump.get(j) == null ? i + 1 : jump.get(j);
                j++;
                continue;
            }
            i++;
        }
        return -1;

    }

    public List<Integer> getJump(String s) {
        List<Integer> jump = new ArrayList<>();
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(0) == s.charAt(i)) {
                jump.add(i);
            }
        }
        return jump;
    }
}
