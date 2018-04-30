package tasks.leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
    public static int largestIsland(int[][] grid) {
        Map<Integer, Integer> key2size = new HashMap<>();
        int key = 2;
        boolean hasZeros = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) hasZeros = true;
                if (grid[i][j] == 1) {
                    key2size.put(key, markAndCount(grid, i, j, key++));
                }
            }
        }
        if (!hasZeros) {
            return grid.length * grid[0].length;
        }
        key2size.put(0, 0);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, area(grid, i, j, key2size));
                }
            }
        }

        return max;
    }

    private static int area(int[][] grid, int i, int j, Map<Integer, Integer> key2size) {
        Set<Integer> uniqueAreas = new HashSet<>();
        if (i > 0) {
            uniqueAreas.add(grid[i-1][j]);
        }
        if (i < grid.length - 1 && grid[i+1][j] != grid[i][j]) {
            uniqueAreas.add(grid[i+1][j]);
        }
        if (j > 0 && grid[i][j-1] != grid[i][j]) {
            uniqueAreas.add(grid[i][j-1]);
        }
        if (j < grid[0].length - 1 && grid[i][j+1] != grid[i][j]) {
            uniqueAreas.add(grid[i][j+1]);
        }
        int sum = 1;
        for (int key : uniqueAreas) {
            sum += key2size.get(key);
        }
        return sum;
    }

    private static int markAndCount(int[][] grid, int i, int j, int key) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if (grid[i][j] != 1) return 0;
        grid[i][j] = key;
        int sum = 1;
        sum += markAndCount(grid, i-1, j, key);
        sum += markAndCount(grid, i+1, j, key);
        sum += markAndCount(grid, i, j-1, key);
        sum += markAndCount(grid, i, j+1, key);
        return sum;
    }

    public static void main(String[] args) {
        //int[][] arr = new int[][]{{0, 1, 0, 1, 1}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {1, 1, 1, 1, 1}};
        int[][] arr = new int[][]{{1,0},{0,1}};
        largestIsland(arr);
    }

}
