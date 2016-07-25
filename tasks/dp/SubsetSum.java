package tasks.dp;

public class SubsetSum {

    public static boolean solve(int[] nums, int total) {
        boolean[][] dp = new boolean[nums.length+1][total+1];
        for (int i = 0; i <=nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < nums[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][total];
    }
}
