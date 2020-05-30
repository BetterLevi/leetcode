/**
 * @author Levi
 * @date 2020.5.30
 */
public class LeetCode_58 {
    public static int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
