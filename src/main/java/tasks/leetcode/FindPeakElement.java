package tasks.leetcode;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (hi-lo)/2+lo;
            if(nums[mid] > nums[mid+1]) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }


}
