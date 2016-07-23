package tasks.dp;

public class MaxSizeSubsquareInMatrix {

    public static int solve(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (dp[i][j] != 0) {
                    dp[i][j] = Math.max(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

}
