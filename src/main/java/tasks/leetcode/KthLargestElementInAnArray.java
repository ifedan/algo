package tasks.leetcode;

public class KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length-1, k);
    }

    public static int findKthLargest(int[] nums, int lo, int hi, int k) {
        if (lo < hi) {
            int pivot = nums[hi];
            int l = lo;
            for (int r = lo; r < hi; r++) {
                if (nums[r]<pivot) {
                    swap(nums, l, r);
                    l++;
                }
            }
            swap(nums, l, hi);

            int diff = nums.length -(l + k);
            if (diff == 0) return nums[l];
            else if (diff < 0) return findKthLargest(nums, lo, l-1, k);
            else return findKthLargest(nums, l+1, hi, k);
        }
        return -1;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
