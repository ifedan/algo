package tasks.leetcode;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max -= 1;
            if (max < 0) return false;
            if (nums[i] > max) {
                max  = nums[i];
            }
        }
        return max>=0;
    }
}
