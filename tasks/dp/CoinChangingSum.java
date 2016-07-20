package tasks.dp;

public class CoinChangingSum {

    public static int solve(int[] coins, int total) {
        int[][] dp = new int[coins.length+1][total+1];
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j<= total; j++) {
                if (j > coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][total];
    }

}
