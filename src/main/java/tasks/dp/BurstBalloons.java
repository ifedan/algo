package tasks.dp;

public class BurstBalloons {

    public static int solve(int[] nums) {
        int[] t = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            t[i+1] = nums[i];
        }
        t[0] = 1;
        t[t.length - 1] = 1;

        int dp[][] = new int[t.length][t.length];
        for (int l = 2; l < t.length; l++) {
            for (int i = 0; i < t.length - l; i++) {
                int j = i + l;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], t[i]*t[k]*t[j] + dp[i][k] + dp[k][j]);
                }
            }
        }

        return dp[0][t.length - 1];
    }

    public static void main(String[] args) {
        solve(new int[]{3,1,5,8});
    }

}
