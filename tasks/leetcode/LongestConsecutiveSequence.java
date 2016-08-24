package tasks.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            visited.add(nums[i]);

            int left = nums[i]-1;
            while (set.contains(left)) {
                visited.add(left--);
            }

            int right = nums[i]+1;
            while (set.contains(right)) {
                visited.add(right++);
            }
            max = Math.max(max, right-left-1);
        }
        return max;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{9000,8999,8998});
    }

}
