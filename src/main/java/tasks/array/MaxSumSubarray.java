package tasks.array;

public class MaxSumSubarray {

    public static int solve(int[] a) {
        int maxHere = a[0];
        int maxSoFar = a[0];

        int cursor = 0;
        int start = 0;
        int end = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxHere+a[i]) {
                maxHere = a[i];
                cursor = i;
            } else {
                maxHere = maxHere+a[i];
            }

            if (maxHere > maxSoFar) {
                maxSoFar = maxHere;
                start = cursor;
                end = i;
            }
        }

        return maxHere;
    }

}
