package tasks.leetcode;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int mid = nums.length/2;
        return find(nums, 0, nums.length-1, mid);
    }

    private static int find(int[] a, int lo, int hi, int k) {
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
            if (l == k) return a[l];
            else if (l < k) find(a, l+1, hi, k);
            else find(a, lo, l-1, k);
        }
        return a[k];
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        majorityElement(new int[]{1});
    }

}
