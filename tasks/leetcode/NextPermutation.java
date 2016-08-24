package tasks.leetcode;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int n = 1;
        int[] a = new int[]{4, 3, 2, 1};
        while (n <= 25) {
            nextPermutation(a);
            System.out.println(Arrays.toString(a));
            n++;
        }
    }

    public static void nextPermutation(int[] nums) {
        int a = -1;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                a = i-1;
                break;
            }
        }
        if (a == -1) {
            reverse(nums);
            return;
        }
        int b = minGreater(nums, a, nums[a]);
        swap(nums, a, b);
        sort(nums, a+1, nums.length-1);
        System.out.println();
    }

    private static int minGreater(int[] a, int start, int val) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = start; i < a.length; i++) {
            if (a[i] > val && a[i] < min) {
                min = a[i];
                index = i;
            }
        }
        return index;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int pivot = a[hi];
            int l = lo;
            for (int r = lo; r < hi; r++) {
                if (a[r] < pivot) {
                    swap(a, l, r);
                    l++;
                }
            }
            swap(a, l, hi);

            sort(a, lo, l-1);
            sort(a, l+1, hi);
        }
    }

    private static void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    private static void reverse(int[] a) {
        for (int i = 0; i < a.length/2; i++) {
            swap(a, i, a.length-1 - i);
        }
    }

}
