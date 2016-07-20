package tasks.dp;

public class Knapsack01 {

    public static int solve(int[] weight, int[] value, int total) {
        int itemCount = weight.length;
        int[][] dp = new int[itemCount+1][total+1];

        for (int i = 1; i <= itemCount; i++) {
            for (int j = 1; j <= total; j++) {
                if (weight[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                }
            }
        }
        return dp[itemCount][total];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{2, 2, 4, 5};
        int[] value = new int[]{2, 4, 6, 9};
        System.out.println(solve(weight, value, 8));
    }

}
