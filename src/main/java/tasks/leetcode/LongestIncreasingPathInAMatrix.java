package tasks.leetcode;

import java.util.*;

public class LongestIncreasingPathInAMatrix {

    private static int max = 0;

    public static int longestIncreasingPath(int[][] matrix) {
        Map<Long, Integer> dp = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                long id = ((long) i << 32) | j;
                if (!dp.containsKey(id)) {
                    findPath(matrix, i, j, dp);
                }
            }
        }
        return dp.values().stream().max(Comparator.comparing(a -> a)).orElse(1);
    }

    private static int findPath(int[][] m, int x, int y, Map<Long, Integer> dp) {
        long id = ((long)x<<32) | y;

        if (dp.containsKey(id)) {
            return dp.get(id);
        }

        dp.put(id, 1);

        int max = 1;

        if (x > 0 && m[x][y] < m[x-1][y]) {
            max = Math.max(max, findPath(m, x-1, y, dp)+ 1);
        }
        if (x < m.length-1 && m[x][y] < m[x+1][y]) {
            max = Math.max(max, findPath(m, x+1, y, dp)+ 1);
        }
        if (y > 0 && m[x][y] < m[x][y-1]) {
            max = Math.max(max, findPath(m, x, y-1, dp) + 1);
        }
        if (y < m[x].length-1 && m[x][y] < m[x][y+1]) {
            max = Math.max(max, findPath(m, x, y+1, dp)+ 1);
        }

        dp.put(id, max);
        return max;
    }



    public static void main(String[] args) {
        //System.out.println(longestIncreasingPath(new int[][] {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        System.out.println(longestIncreasingPath(new int[][] {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
    }

}
