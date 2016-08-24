package tasks.leetcode;

public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int excl = 0;
        int incl = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = incl;
            incl = Math.max(incl, excl+nums[i]);
            excl = temp;
        }
        return Math.max(incl, excl);
    }

}
