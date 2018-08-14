package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
        maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1);
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> sum2Pos = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int candidate = sum - k;
            if (candidate == 0) {
                max = Math.max(max, i+1);
            }
            Integer candidateIndex = sum2Pos.get(candidate);
            if (candidateIndex != null) {
                max = Math.max(max, (i - candidateIndex));
            }
            int index = i;
            sum2Pos.computeIfAbsent(sum, key -> index);
        }
        return max;
    }
}
