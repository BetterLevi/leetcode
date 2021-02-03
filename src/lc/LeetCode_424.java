package lc;

/**
 * 双指针
 *
 * @author wei.liang
 * @since 2021/2/3
 */
public class LeetCode_424 {

    public int characterReplacement(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            int tmp = k;
            int count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == first) {
                    count++;
                    continue;
                }
                if (tmp != 0) {
                    count++;
                    tmp--;
                } else {
                    break;
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public int betterSolution(String s, int k) {
        int len = s.length();
        int[] appearNum = new int[26];
        int right = 0;
        int left = 0;
        int maxNum = 0;
        while (right < len) {
            int index = s.charAt(right) - 'A';
            appearNum[index]++;
            maxNum = Math.max(maxNum, appearNum[index]);
            if (right - left + 1 - maxNum > k) {
                appearNum[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        LeetCode_424 leetCode_424 = new LeetCode_424();
        System.out.println(leetCode_424.betterSolution("ABBBBA", 2));
    }
}
