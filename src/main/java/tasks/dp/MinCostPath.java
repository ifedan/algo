package tasks.dp;

public class MinCostPath {

    public static int[][] solve(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int sum = 0;
        for (int i = 1; i < dp.length; i++) {
            sum += matrix[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < dp[0].length; i++) {
            sum += matrix[0][i];
            dp[0][i] = sum;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp;
    }

}
