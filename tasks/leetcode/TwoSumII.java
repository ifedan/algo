package tasks.leetcode;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int res = numbers[i]  + numbers[j];
            if (res == target) return new int[]{i+1, j+1};
            else if (res > target) j--;
            else i++;
        }

        return null;
    }

}
