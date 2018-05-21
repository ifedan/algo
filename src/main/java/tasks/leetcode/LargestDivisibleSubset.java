package tasks.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return Collections.EMPTY_LIST;
        int[] dp = new int[nums.length];
        int[] seq = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(seq, -1);
        Arrays.sort(nums);
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        seq[i] = j;
                    }
                    if (dp[maxIndex] < dp[i]) {
                        maxIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        do{
            result.add(nums[maxIndex]);
            maxIndex = seq[maxIndex];
        } while (maxIndex > -1);

        return result;
    }

}
