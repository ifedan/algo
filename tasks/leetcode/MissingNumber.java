package tasks.leetcode;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[0];
                nums[0] = 0;
            }
        }
        if (nums[0] != 0) return 0;

        for (int i = 1; i < nums.length; i++) {
            int index = Math.abs(nums[i]);

            if (index > nums.length-1) {
                continue;
            }
            nums[index] *= -1;
        }
        int min = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) return i;
            min = Math.min(min, nums[i]);
        }
        return min + 1;
    }

}
