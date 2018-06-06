package tasks.leetcode;

public class MagicSquaresInGrid {
    public static int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) return 0;
        int count = 0;
        for (int i = 2; i < grid.length; i++) {
            for (int j = 2; j < grid[i].length; j++) {
                int mask = mask(grid[i-2][j-2]) | mask(grid[i-2][j-1]) | mask(grid[i-2][j]) |
                        mask(grid[i-1][j-2]) | mask(grid[i-1][j-1]) | mask(grid[i-1][j]) |
                        mask(grid[i][j-2]) | mask(grid[i][j-1]) | mask(grid[i][j]);
                if ((mask ^ ((1<<9)-1)) != 0) continue;
                int sum = grid[i][j] + grid[i-1][j-1] + grid[i-2][j-2];
                if (//diagonal
                        sum == grid[i-2][j] + grid[i-1][j-1] + grid[i][j-2] &&
                                //horizontal
                                sum == grid[i-2][j] + grid[i-2][j-1] + grid[i-2][j-2] &&
                                sum == grid[i-1][j] + grid[i-1][j-1] + grid[i-1][j-2] &&
                                sum == grid[i][j] + grid[i][j-1] + grid[i][j-2] &&
                                //vertical
                                sum == grid[i-2][j] + grid[i-2][j-1] + grid[i-2][j-2] &&
                                sum == grid[i-1][j] + grid[i-1][j-1] + grid[i-1][j-2] &&
                                sum == grid[i][j] + grid[i][j-1] + grid[i][j-2]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int mask(int val) {
        return  (val > 9 || val < 1) ? (1<<9) : (1<<(val-1));
    }

    public static void main(String[] args) {
        numMagicSquaresInside(new int[][]{{10,3,5},{1,6,11},{7,9,2}});
    }
}
