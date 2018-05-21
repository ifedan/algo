package tasks.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[r] + nums[l];
                if (minDiff > Math.abs(target - sum)) {
                    minDiff = Math.abs(target - sum);
                    minSum = sum;
                }
                if (minDiff == 0) return sum;
                if (sum > target) r--;
                if (sum < target) l++;
            }
        }
        return minSum;
    }

}
