package tasks.array;

public class MaxSumIncreasingSubarray {

    public static int solve(int[] a) {
        int dp[] = new int[a.length];
        int pos[] = new int[a.length];

        for (int i = 0; i< a.length; i++) {
            dp[i] = a[i];
            pos[i] = i;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], a[i] + dp[j]);
                    pos[i] = j;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
