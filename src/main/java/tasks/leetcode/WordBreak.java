package tasks.leetcode;

import java.util.Set;

public class WordBreak {

    public static boolean wordBreak(String s, Set<String> wordDict) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;

                if (wordDict.contains(new String(s.toCharArray(), i, len))) {
                    dp[i][j] = true;
                } else {
                    for (int k = i; k < j; k++) {
                        dp[i][j] = dp[i][j] | (dp[i][k] & dp[k+1][j]);
                        if (dp[i][j]) break;
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }

}
