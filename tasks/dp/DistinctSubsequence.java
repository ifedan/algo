package tasks.dp;

public class DistinctSubsequence {

    public static int solve(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return 0;

        int[][] dp = new int[str1.length()+1][str1.length()+1];
        for (int i = 0; i < str1.length(); i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

}
