package tasks.dp;

public class MatrixChainMultiplication {

    public static int solve(int[][] matrices) {
        int[][] dp = new int[matrices.length][matrices.length];
        for (int l = 2; l < matrices.length; l++) {
            for (int i = 0; i < matrices.length - l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + matrices[i][0]*matrices[k][1]*matrices[j][0]);
                }
            }
        }

        return dp[0][matrices.length-1];

    }

}
