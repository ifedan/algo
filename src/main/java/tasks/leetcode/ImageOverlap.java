package tasks.leetcode;

public class ImageOverlap {
    public static int largestOverlap(int[][] A, int[][] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                max = Math.max(max, max(A, B, i, j));
            }
        }
        return max;
    }

    public static int max(int[][] a, int[][] b, int x, int y) {
        int max = 0;
        int h = a.length;
        int w = a[0].length;
        max = Math.max(max, compare(a, 0, 0, b, w - x - 1, h - y - 1, x, y));
        max = Math.max(max, compare(a, x, 0, b, 0, h - y - 1, w - x - 1, y));
        max = Math.max(max, compare(a, 0, y, b, w - x - 1, 0, x, h - y - 1));
        max = Math.max(max, compare(a, x, y, b, 0, 0, w - x - 1, h - y - 1));
        return max;
    }

    public static int compare(int[][] a, int xA, int yA, int[][] b, int xB, int yB, int w, int h) {
        int same = 0;
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= w; j++) {
                if (a[yA+i][xA+j] == 1 && b[yB+i][xB+j] == 1) same++;
            }
        }
        return same;
    }

    public static void main(String[] args) {
        int a[][] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int b[][] = new int[a.length][a[0].length];

        max(a, b, 9, 0);
    }
}
