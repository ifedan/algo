package tasks.leetcode;

public class SearchForRange {

    public static int[] searchRange(int[] nums, int target) {
        int i = binarySearch(nums, target, true, false);
        if (i == -1) return new int[]{-1, -1};
        int x = binarySearch(nums, target - 0.5, false, true);
        int y = binarySearch(nums, target + 0.5, false, false);
        return new int[]{x, y};
    }

    private static int binarySearch(int[] a, double val, boolean negativeOnAbsent, boolean left) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (hi-lo)/2 + lo;
            if (a[mid] == val) {
                return mid;
            } else if (a[mid] > val){
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }

        if (negativeOnAbsent) return -1;

        return left ? lo : hi;
    }

}
