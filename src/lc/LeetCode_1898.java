package lc;

/**
 * @author wei.liang
 * @since 2021/6/15
 */
public class LeetCode_1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] sc = s.toCharArray();
        for (int i = 0; i < removable.length; i++) {
            sc[removable[i]] = ' ';
            s = String.valueOf(sc).replaceAll(" ", "");
            if (!isSubsequence(p, s)) {
                return i;
            }
        }
        return removable.length;
    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        LeetCode_1898 lc = new LeetCode_1898();
        int[] rm = {5,3,0,6,4,9,10,7,2,8};
        System.out.println(lc.maximumRemovals("qobftgcueho", "obue", rm));
    }
}
