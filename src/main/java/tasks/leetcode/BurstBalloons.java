package tasks.leetcode;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int[] t = new int[nums.length+2];
        for (int i = 0; i < nums.length; i++) {
            t[i+1] = nums[i];
        }
        t[0] = 1;
        t[nums.length+1] = 1;

        int[][] dp = new int[t.length][t.length];
        for (int len = 2; len < t.length; len++) {
            for (int i = 0; i < t.length-len; i++) {
                int j = i + len;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + t[i]*t[k]*t[j]);
                }
            }
        }

        return dp[0][t.length - 1];
    }

}
