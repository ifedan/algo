package tasks.leetcode;

public class LongestMountainInArray {
    public static int longestMountain(int[] A) {
        int[] forward = new int[A.length];
        int[] back = new int[A.length];

        for (int i = 1; i < A.length; i++) {
            if (A[i-1] < A[i]) {
                forward[i] = forward[i-1] + 1;
            }
        }

        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i+1]) {
                back[i] = back[i+1] + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < A.length - 1; i++) {
            if (forward[i] > 0 && back[i] > 0) {
                max = Math.max(max, forward[i] + back[i] + 1);
            }
        }
        return max >= 3 ? max : 0;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2,2,2}));
    }
}
