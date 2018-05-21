package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        trace(matrix, result);
        return result;
    }

    public static void trace(int[][] a, List<Integer> result) {
        int top = 0;
        int bottom = a.length-1;
        int left = 0;
        int right = a[0].length-1;

        while (true) {
            moveRight(a, top, left, right, result);
            top++;
            if (top > bottom) break;
            moveDown(a, right, top, bottom, result);
            right--;
            if (right < left) break;
            moveLeft(a, bottom, left, right, result);
            bottom--;
            if (top > bottom) break;
            moveUp(a, left, top, bottom, result);
            left++;
            if (right < left) break;
        }
    }

    private static void moveRight(int[][] a, int row, int lo, int hi, List<Integer> result) {
        for (int i = lo; i <= hi; i++) {
            result.add(a[row][i]);
        }
    }

    private static void moveLeft(int[][] a, int row, int lo, int hi, List<Integer> result) {
        for (int i = hi; i >= lo; i--) {
            result.add(a[row][i]);
        }
    }

    private static void moveUp(int[][] a, int col, int lo, int hi, List<Integer> result) {
        for (int i = hi; i >= lo; i--) {
            result.add(a[i][col]);
        }
    }

    private static void moveDown(int[][] a, int col, int lo, int hi, List<Integer> result) {
        for (int i = lo; i <= hi; i++) {
            result.add(a[i][col]);
        }
    }

}