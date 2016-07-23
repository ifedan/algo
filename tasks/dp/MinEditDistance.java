package tasks.dp;

public class MinEditDistance {

    public static int solve(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (str1.charAt(i) == str1.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[str1.length()][str1.length()];
    }

}
