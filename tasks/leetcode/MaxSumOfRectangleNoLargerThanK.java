
package tasks.leetcode;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {

    public void maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;
        int h = matrix.length;
        int w = matrix[0].length;
        int[] sum = new int[w];
        for (int i = 0; i < h; i++) {
            for (int j = i; j < h; j++) {
                if (i == j) System.arraycopy(matrix[i], 0, sum, 0, sum.length);
                else for (int p = 0; p < w; p++) sum[p]+=matrix[j][p];
                max = Math.max(max, maxSum(sum, k));
            }
        }
    }

    private static int maxSum(int[] a , int k){
        int max = Integer.MIN_VALUE;
        int sumj = 0;
        TreeSet<Integer> s = new TreeSet<>();
        s.add(0);

        for(int i=0;i<a.length;i++){
            sumj += a[i];
            Integer gap = s.ceiling(sumj - k);
            if(gap != null) max = Math.max(max, sumj - gap);
            s.add(sumj);
        }

        return max;
    }

    public static void main(String[] args) {

        int[] a = new int[]{4, 2, -1, 3, 4, 5, -4, 6, 4, -2};
        maxSum(a, 7);

    }

}
