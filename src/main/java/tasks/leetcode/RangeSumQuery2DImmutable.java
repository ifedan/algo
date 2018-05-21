package tasks.leetcode;

public class RangeSumQuery2DImmutable {

    public static class NumMatrix {

        int segment[][];
        int matrix[][];

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            this.segment = new int[matrix.length][matrix[0].length];
            if (matrix.length > 0) {
                createSegments();
            }
        }

        private void createSegments() {
            segment[0][0] = matrix[0][0];
            for (int i = 1; i < matrix.length; i++) {
                segment[i][0] = segment[i-1][0] + matrix[i][0];
            }
            for (int j = 1; j < matrix[0].length; j++) {
                segment[0][j] = segment[0][j-1] + matrix[0][j];
            }

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    segment[i][j] = segment[i-1][j] + segment[i][j-1] - segment[i-1][j-1] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = segment[row2][col2];
            if (row1 > 0) {
                res -= segment[row1-1][col2];
            }
            if (col1 > 0) {
                res -= segment[row2][col1-1];
            }
            if (row1>0 && col1>0) {
                res += segment[row1-1][col1-1];
            }
            return res;
        }
    }

    public static void main(String[] args) {

        //[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]],sumRegion(2,1,4,3),sumRegion(1,1,2,2),sumRegion(1,2,2,4)
        NumMatrix m = new NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        m.sumRegion(2, 1, 4, 3);
    }

}
