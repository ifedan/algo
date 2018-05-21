package tasks.leetcode;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int h = grid.length;
        if (h == 0) return 0;
        int w = grid[0].length;
        if (w == 0) return 0;
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    fill(grid, i, j);
                }
            }
        }

        return count;
    }

    private void fill(char[][] grid, int i, int j) {
        int h = grid.length;
        int w = grid[0].length;
        if (i < 0 || i >= h || j < 0 || j >= w) return;

        if (grid[i][j]== '0') return;

        grid[i][j] = '0';

        fill(grid, i+1, j);
        fill(grid, i-1, j);
        fill(grid, i, j+1);
        fill(grid, i, j-1);
    }

}
