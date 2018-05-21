package tasks.leetcode;

import java.util.Arrays;

public class PerfectSquares {

    private static int min = Integer.MAX_VALUE;

    public static void findPerfectSquare(int sum, int val) {
        if (val > min) return;
        if (sum == 0) {
            min = Math.min(min, val);
            return;
        }
        int sqrt = (int)Math.sqrt(sum);
        for (int i = sqrt; i >= 1; i--) {
            int sqr = i*i;
            if (sqr > sum) break;
            findPerfectSquare(sum - sqr, val+1);
        }
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int i = 1;
        int sqr = i * i;
        while (sqr <= n) {
            for (int j = sqr; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - sqr] + 1);
            }
            i++;
            sqr = i*i;
        }
        return dp[n];

    }

}
