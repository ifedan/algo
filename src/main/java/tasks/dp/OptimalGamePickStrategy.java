package tasks.dp;

public class OptimalGamePickStrategy {

    static class Pick {
        int first;
        int second;
        int pick;
        Pick(int p, int f, int s) {
            this.pick = p;
            this.first = f;
            this.second = s;
        }
    }

    public static Pick solve(int[] a) {
        Pick[][] dp = new Pick[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i][i] = new Pick(i, a[i], 0);
        }

        for (int l = 2; l < a.length; l++) {
            for (int i = 0; i < a.length-l; i++) {
                int j = i+l-1;

                if (dp[i][j-1].second + a[j] > dp[i+1][j].second + a[i]) {
                    dp[i][j] = new Pick(i, dp[i][j-1].second + a[j], dp[i][j-1].first);
                } else {
                    dp[i][j] = new Pick(j, dp[i+1][j].second + a[i], dp[i+1][j].first);
                }
            }
        }

        return dp[0][a.length-1];
    }

}
