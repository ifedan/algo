package tasks.leetcode;

import java.util.Arrays;

public class NextClosestTime {
    public static String nextClosestTime(String time) {
        int n1 = time.charAt(0) - '0';
        int n2 = time.charAt(1) - '0';
        int n3 = time.charAt(3) - '0';
        int n4 = time.charAt(4) - '0';
        int[] nums = new int[]{n1, n2, n3, n4};
        int[] sorted = new int[]{n1, n2, n3, n4};
        Arrays.sort(sorted);
        int[] maxValues = new int[]{2, (n1 == 2) ? 3 : 9, 5, 9};

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != sorted[3] && nums[i] < maxValues[i]) {
                for (int j = 0; j < sorted.length; j++) {
                    if (sorted[j] > nums[i] && sorted[j] <= maxValues[i]) {
                        nums[i] = sorted[j];
                        return "" + nums[0] + nums[1] + ":" + nums[2] + nums[3];
                    }
                }
            }
            nums[i] = sorted[0];
        }
        return "" + nums[0] + nums[1] + ":" + nums[2] + nums[3];
    }

    public static void main(String[] args) {
        nextClosestTime("19:34");
    }
}
