/**
 * 通配符匹配
 *
 * @author Levi
 * @date 2020.7.5
 */
public class LeetCode_44 {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int m = s.length(), n = p.length();
        int last_match = -1, starj = -1;
        while (i < m){
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++; j++;
            }
            else if (j < n && p.charAt(j) == '*'){
                starj = j;
                j++;
                last_match = i;
            }
            else if (starj != -1){
                j = starj + 1;
                last_match++;
                i = last_match;
            }
            else return false;
        }
        while (j < n && p.charAt(j) == '*') j++;
        return j == n;
    }
}
