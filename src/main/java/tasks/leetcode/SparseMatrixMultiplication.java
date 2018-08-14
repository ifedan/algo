package tasks.leetcode;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) { //row for A
            for(int k = 0; k < A[0].length; k++) { //col for A // rows for B
                if (A[i][k] != 0) {
                    for (int j = 0; j < B[0].length; j++) { //col for B
                        result[i][j] = result[i][j] + (A[i][k] * B[k][j]);
                    }
                }
            }
        }
        return result;
    }
}
