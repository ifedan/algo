package tasks.leetcode;

public class MaximumSumOf3NonOverlappingSubarrays {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < k; i++) {
            sumLeft += nums[i];
            sumRight += nums[nums.length - i - 1];
        }
        for (int i = k-1; i < nums.length; i++) {
            if (i != k-1) {
                sumLeft += (nums[i] - nums[i - k]);
                sumRight += (nums[nums.length - i - 1] - nums[nums.length - i - 1 + k]);
            }
            left[i] = Math.max(i == 0 ? -1 : left[i-1], sumLeft);
            right[nums.length - i - 1] = Math.max(i == 0 ? -1 : right[nums.length - i], sumRight);
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[k+i];
        }
        int max = 0;
        int maxIndex = -1;
        for (int i = k+k-1; i < nums.length-k; i++) {
            if (i != k+k-1) {
                sum = sum - nums[i-k] + nums[i];
            }
            int s = sum + left[i-k] + right[i+1];
            if (s > max) {
                max = s;
                maxIndex = i;
            }
        }
        int l = -1;
        int r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (l == -1 && left[maxIndex-k] == left[i]) {
                l = i-k+1;
            }
            if (r == -1 && right[maxIndex+1] == right[nums.length-1-i]) {
                r = nums.length-1-i;
            }
            if (l > 0 && r > 0) break;
        }
        return new int[]{l, maxIndex-k+1, r};
    }


    public static void main(String[] args) {
        maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2);
        //maxSumOfThreeSubarrays(new int[]{4,5,10,6,11,17,4,11,1,3}, 1);
    }
}
