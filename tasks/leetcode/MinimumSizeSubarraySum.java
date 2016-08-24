package tasks.leetcode;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        minSubArrayLen(4, new int[]{1, 4, 4});
    }

}
