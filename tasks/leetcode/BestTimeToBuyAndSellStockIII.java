package tasks.leetcode;

public class BestTimeToBuyAndSellStockIII {

    public static int maxProfit3(int[] prices) {
        int[][] dp = new int[3][prices.length];
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j < prices.length; j++) {

                int max = 0;
                for (int m = 0; m < j; m++) {
                    max = Math.max(max, prices[j] - prices[m] + dp[i-1][m]);
                }
                dp[i][j] = Math.max(max, dp[i][j-1]);
            }
        }
        return dp[2][prices.length-1];
    }

    public static int maxProfit3Updated(int[] prices) {
        int[][] dp = new int[3][prices.length];
        for (int i = 1; i <= 2; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[2][prices.length - 1];
    }

    }
