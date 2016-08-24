package tasks.leetcode;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            if (nums[i] != 0) {
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
                j++;
            }
            i++;
        }
    }

}
