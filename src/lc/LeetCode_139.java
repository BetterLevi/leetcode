package lc;

import java.util.List;

/**
 * 单词拆分
 * @author Levi
 * @date 2020.8.26
 */
public class LeetCode_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1 && wordDict.contains(s.substring(j, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1;
    }
}
