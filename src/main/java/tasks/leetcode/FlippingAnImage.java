package tasks.leetcode;

public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int line = 0; line < A.length; line++) {
            int i = 0;
            int j = A[line].length - 1;
            while (i < j) {
                int tmp = A[line][i];
                A[line][i] = A[line][j] ^ 1; //inverse
                A[line][j] = tmp ^ 1; //inverse
                i++;
                j--;
            }
            if (i == j) A[line][i] = A[line][i] ^ 1;
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] res = flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}});
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
