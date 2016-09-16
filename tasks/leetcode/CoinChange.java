package tasks.leetcode;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length+1][amount+1];

        for (int i = 0; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    int include = dp[i][j - coins[i-1]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i][j - coins[i-1]] + 1;
                    dp[i][j] = Math.min(dp[i-1][j], include);
                }
            }
        }

        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int r = coinChange(new int[]{2}, 3);
        System.out.println(r);
    }

}
