package tasks.leetcode;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-i-1; j++) {
                int t0 = matrix[i][j];
                int t1 = matrix[j][n-i-1];
                int t2 = matrix[n-i-1][n-j-1];
                int t3 = matrix[n-j-1][i];

                matrix[i][j] = t3;
                matrix[j][n-i-1] = t0;
                matrix[n-i-1][n-j-1] = t1;
                matrix[n-j-1][i] = t2;
            }
        }
    }

}
