package tasks.leetcode;

public class HouseRobberII {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0],nums[2]), nums[1]);

        int incl = nums[2];
        int excl = 0;
        for (int i = 3; i < nums.length-1; i++) {
            int temp = incl;
            incl = Math.max(excl + nums[i], incl);
            excl = temp;
        }
        int firstIncl = Math.max(incl, excl) + nums[0];

        incl = nums[1];
        excl = 0;
        for (int i = 2; i < nums.length; i++) {
            int temp = incl;
            incl = Math.max(excl + nums[i], incl);
            excl = temp;
        }
        int firstExcl = Math.max(incl, excl);

        return Math.max(firstExcl, firstIncl);
    }


}
