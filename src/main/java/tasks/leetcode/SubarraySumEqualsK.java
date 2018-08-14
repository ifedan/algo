package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        subarraySum(new int[]{2, 5, 4, 4, 1}, 9);
    }
    public static int subarraySum(int[] nums, int k) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + dp[i-1];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                int sum = dp[i] - dp[j] + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer countOfRest = count.get(sum - k);
            if (countOfRest != null) {
                result += countOfRest;
            }
            count.merge(sum, 1, (val, acc) -> val + acc);
        }
        return result;
    }
}
