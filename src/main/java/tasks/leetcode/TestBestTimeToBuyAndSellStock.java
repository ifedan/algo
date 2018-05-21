package tasks.leetcode;

public class TestBestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices, int n) {
        int[][] dp = new int[n+1][prices.length];

        for (int i = 1; i <= dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 1; k < j; k++) {
                    max = Math.max(max, prices[j] - prices[k] + dp[i-1][j]);
                }
                dp[i][j] = Math.max(max, dp[i][j-1]);
            }
        }

        return dp[n][prices.length-1];
    }

}
