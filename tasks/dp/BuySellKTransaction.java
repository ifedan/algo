package tasks.dp;

public class BuySellKTransaction {

    public static int solve(int[] prices, int k) {

        int[][] dp = new int[k+1][prices.length];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < prices.length; j++) {
                int max = Integer.MIN_VALUE;
                for (int m = 1; m < j; m++) {
                    max = Math.max(max, prices[j] - prices[m] + dp[i-1][m]);
                }
                dp[i][j] = Math.max(max, dp[i][j-1]);
            }
        }
        return dp[k][prices.length];
    }


    public static void main(String[] args) {
        solve(new int[]{2, 5, 7, 1, 3, 4}, 2);
    }

}
