package tasks.leetcode;

public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;

        int j = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i-1] == nums[i] && nums[i-2] == nums[i]) {
                j = i;
                break;
            }
        }
        if (j < 2) {
            return nums.length;
        }

        for (int i = j+1; i < nums.length; i++) {
            if (nums[i] != nums[j-1] || nums[i] != nums[j-2]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,1,2,2,3});
    }

}
