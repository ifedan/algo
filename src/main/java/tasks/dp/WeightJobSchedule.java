package tasks.dp;

import java.util.Arrays;

public class WeightJobSchedule {

    static class Job implements Comparable<Job> {
        int start;
        int end;
        int weight;

        @Override
        public int compareTo(Job o) {
            return start - o.start;
        }
    }

    public static int solve(Job[] jobs) {
        Arrays.sort(jobs);
        int[] dp = new int[jobs.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = jobs[i].weight;
        }
        for (int i = 1; i < jobs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (jobs[i].start > jobs[j].end) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i].weight);
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
