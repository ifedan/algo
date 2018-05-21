package tasks.leetcode;

public class TwoSum {

    public static int[] twoSum(int[] a, int sum) {
        int i = 0;
        int j = a.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int minI = 0;
        int minJ = 0;
        while (i < j) {
            int currSum = a[j] + a[i];
            int diff = Math.abs(sum - currSum);
            if (diff < minDiff) {
                minDiff = diff;
                minI = i;
                minJ = j;
            }
            if (currSum == sum) {
                break;
            }
            if (currSum > sum) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{minI, minJ};
    }

}
