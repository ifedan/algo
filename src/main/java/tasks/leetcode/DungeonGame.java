package tasks.leetcode;

public class DungeonGame {

    public static int calculateMinimumHP(int[][] dungeon) {
        int h = dungeon.length;
        int w = h == 0 ? 0 : dungeon[0].length;
        int[][] dp = new int[h+1][w+1];
        for (int i = 0; i < h+1; i++) {
            dp[i][w] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < w+1; i++) {
            dp[h][i] = Integer.MAX_VALUE;
        }
        dp[h][w - 1] = 0;
        dp[h - 1][w] = 0;


        for (int i = h-1; i >= 0; i--) {
            for (int j = w-1; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 0);
            }
        }
        return dp[0][0]+1;
    }

}
