package tasks.leetcode;

public class SplitArrayWithSameAverage {
  public static boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
        }
        boolean[][] sums = new boolean[sum + 1][A.length + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if (sums[j][0]) {
                    sums[j + A[i]][0] = true;
                    for (int k = 1; k < A.length; k++) {
                        if (sums[j][k]) {
                            sums[j + A[i]][k + 1] = true;
                        }
                    }
                }
            }
            sums[A[i]][0] = true;
            sums[A[i]][1] = true;
        }
        for (int i = 0; i < sum; i++) {
            if (sums[i][0]) {
                for (int j = 1; j < A.length; j++) {
                    if (!sums[i][j]) continue;
                    if ((A.length-j) * i == (sum - i) * j) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
