package tasks.leetcode;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        if (nums.length == 1) {
            if (nums[0] != 1) return 1;
            else return 2;
        }

        int j = 0;
        for (j = 0; j < nums.length && nums[j] <= 0; j++);

        if (j == nums.length) return 1;

        for (int i = j+1; i < nums.length; i++) {
            if (nums[i] <= 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
        }

        for (int i = j; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            idx = idx + j - 1;
            if (idx >= nums.length) continue;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = j; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                index = i;
            }
            if (nums[i] > 0) {
                return i - j + 1;
            }
        }
        return (-1 * nums[index]) + 1;
    }

}
