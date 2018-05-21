package tasks.dp;

public class CuttingRod {

    public static int solve(int[] cuts, int[] profit, int total) {
        int[][] dp = new int[cuts.length+1][total+1];
        for (int i = 1; i <= cuts.length; i++) {
            for (int j = 1; j<= total; j++) {
                if (j < cuts[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-cuts[i-1]] + profit[i-1]);
                }
            }
        }
        return dp[cuts.length][total];
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,3,4}, new int[]{2,5,7,8}, 5));
    }
}
