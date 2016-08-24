package tasks.leetcode;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length];
        a[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            a[i] = a[i-1]*nums[i-1];
        }
        int[] b = new int[nums.length];
        b[nums.length-1] = 1;
        for (int i = nums.length - 2; i>= 0; i--) {
            b[i] = b[i+1] * nums[i+1];
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = a[i]*b[i];
        }
        return output;
    }

}
