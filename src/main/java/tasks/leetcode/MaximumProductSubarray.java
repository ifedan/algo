package tasks.leetcode;

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int maxPos = nums[0];
        int minNeg = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = minNeg;
            minNeg = Math.min(nums[i], Math.min(minNeg * nums[i], maxPos * nums[i]));
            maxPos = Math.max(nums[i], Math.max(maxPos * nums[i], temp * nums[i]));
            max = Math.max(max, maxPos);
        }
        return max;
    }

}
