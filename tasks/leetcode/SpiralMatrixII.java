package tasks.leetcode;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) return result;
        trace(result);
        return result;
    }

    private static class Index {
        int i = 1;
    }

    public static void trace(int[][] a) {
        int top = 0;
        int bottom = a.length-1;
        int left = 0;
        int right = a[0].length-1;
        Index i = new Index();

        while (true) {
            moveRight(a, top, left, right, i);
            top++;
            if (top > bottom) break;
            moveDown(a, right, top, bottom, i);
            right--;
            if (right < left) break;
            moveLeft(a, bottom, left, right, i);
            bottom--;
            if (top > bottom) break;
            moveUp(a, left, top, bottom, i);
            left++;
            if (right < left) break;
        }
    }

    private static void moveRight(int[][] a, int row, int lo, int hi, Index val) {
        for (int i = lo; i <= hi; i++) {
            a[row][i] = val.i;
            val.i++;
        }
    }

    private static void moveLeft(int[][] a, int row, int lo, int hi, Index val) {
        for (int i = hi; i >= lo; i--) {
            a[row][i] = val.i;
            val.i++;
        }
    }

    private static void moveUp(int[][] a, int col, int lo, int hi, Index val) {
        for (int i = hi; i >= lo; i--) {
            a[i][col] = val.i;
            val.i++;
        }
    }

    private static void moveDown(int[][] a, int col, int lo, int hi, Index val) {
        for (int i = lo; i <= hi; i++) {
            a[i][col] = val.i;
            val.i++;
        }
    }

}
