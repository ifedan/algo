package tasks.dp;

public class MinimumJump {

    public static int solve(int[] cost) {
        int[] dp = new int[cost.length];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (cost[j] <= (i-j)) {
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[dp.length-1];
    }

}
