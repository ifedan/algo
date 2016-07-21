package tasks.dp;

public class EggDropping {

    public static int solve(int eggCount, int floorCount) {
        int dp[][] = new int[eggCount+1][floorCount+1];

        for (int i = 0; i<=floorCount; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= eggCount; i++) {
            for (int j = 1; j <= floorCount; j++) {
                int min = Integer.MAX_VALUE;
                for (int m = 1; m <= j; m++) {
                    min = Math.min(min, 1 + Math.max(dp[i - 1][m - 1], dp[i][j - m]));
                }
                dp[i][j] = min;
            }
        }

        return dp[eggCount][floorCount];
    }

    public static void main(String[] args) {
        System.out.println(solve(2, 6));
    }

}
