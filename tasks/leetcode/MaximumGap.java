package tasks.leetcode;

import java.util.Arrays;

public class MaximumGap {

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        if (nums.length == 2) return Math.abs(nums[0]-nums[1]);

        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int gap = (int)Math.ceil((double)(max - min)/(nums.length - 1));
        int[] bucketsMIN = new int[nums.length - 1];
        int[] bucketsMAX = new int[nums.length - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == min || nums[i] == max) continue;
            int idx = (nums[i]-min)/gap;
            bucketsMIN[idx] = Math.min(bucketsMIN[idx], nums[i]);
            bucketsMAX[idx] = Math.max(bucketsMAX[idx], nums[i]);
        }

        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous);

        return maxGap;
    }

    public static void main(String[] args) {
        maximumGap(new int[]{1, 1, 1, 1});
    }

}
