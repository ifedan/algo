package tasks.array;

public class MaxSumSubsequenceNonAdjacent {

    public static int solve(int[] a) {
        int incl = a[0];
        int excl = 0;

        for (int i = 1; i < a.length; i++) {
            int temp = incl;
            incl = Math.max(excl + a[i], incl);
            excl = temp;
        }

        return Math.max(incl, excl);
    }

}
