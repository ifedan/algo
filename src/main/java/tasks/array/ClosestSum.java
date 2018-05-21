package tasks.array;

public class ClosestSum {

    public static void solve(int[] a, int sum) {
        int l = 0;
        int r = a.length - 1;
        int min = Integer.MAX_VALUE;

        int left;
        int right;

        while (l < r) {
            int testSum = a[l] + a[r];
            if (min > Math.abs(sum-testSum)) {
                min = Math.abs(sum-testSum);
                left = l;
                right = r;
            }

            if (testSum < sum) {
                l++;
            } else {
                r--;
            }

        }
    }
}
