package tasks.leetcode;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (i != j && nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            if (j == 0 || nums[j-1] != nums[j]) {
                j++;
            }
            i++;
        }
        return j;
    }

}
