package tasks.array;

public class MaxSumRectangleSubmatrix {

    public static int solve(int[][] matrix) {
        int[] a = new int[matrix.length];
        int max = Integer.MIN_VALUE;
        int left;
        int right;
        int top;
        int down;
        for (int l = 0; l < matrix[0].length; l++) {
            for (int k = 0; k < a.length; k++) {
                a[k] = 0;
            }
            for (int r = l; r < matrix[0].length; r++) {
                for (int k = 0; k < a.length; k++) {
                    a[k] += matrix[k][r];
                }
                KadaneResult res = getMaxSumSubarray(a);
                if (max < res.max) {
                    max = res.max;
                    top = res.start;
                    down = res.end;
                    left = l;
                    right = r;
                }
            }
        }
        return max;
    }

    static class KadaneResult {
        int start;
        int end;
        int max;
        KadaneResult(int s, int e, int m) {
            start = s;
            end = e;
            max = m;
        }
    }

    private static KadaneResult getMaxSumSubarray(int[] a) {
        int maxHere = a[0];
        int maxSoFar = a[0];
        int start = 0;
        int end = 0;
        int cursor = 0;

        for (int i = 1; i < a.length; i++) {
            if (maxHere + a[i] < a[i]) {
                maxHere = a[i];
                cursor = i;
            } else {
                maxHere = maxHere + a[i];
            }

            if (maxHere > maxSoFar) {
                maxSoFar = maxHere;
                start = cursor;
                end = i;
            }
        }
        return new KadaneResult(start, end, maxSoFar);
    }

}
