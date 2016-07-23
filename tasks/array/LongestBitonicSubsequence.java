package tasks.array;

public class LongestBitonicSubsequence {

    public static int solve(int[] a) {
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        for (int i = 0; i < left.length; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    left[i] = Math.max(left[i], left[j]+1);
                }
            }
        }

        for (int i = right.length - 2; i >= 0; i--) {
            for (int j = right.length -1; j > i; j--) {
                if (a[i] > a[j]) {
                    right[i] = Math.max(right[i], right[j]+1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < right.length; i++) {
            max = Math.max(max, right[i] + left[i] - 1);
        }

        return max;
    }

}
