package tasks.dp;

public class LongestPalindromicSubsequence {

    public static int solve(String str) {
        if (str == null || str.length() == 0) return 0;
        int[][] dp = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }
        for (int l = 2; l <= str.length(); l++) {
            for (int i = 0; i <= str.length() - l; i++) {
                int j = l + i - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    if (l == 2) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[str.length()-1][str.length()-1];
    }

}
