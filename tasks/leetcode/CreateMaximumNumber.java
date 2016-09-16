package tasks.leetcode;

public class CreateMaximumNumber {

  public static int[] maxSubseq(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k-i));
            if (isGreater(temp, 0, res, 0)) {
                res = temp;
            }
        }
        return res;
    }

    public static int[] maxArray(int[] a, int count) {
        int[] res = new int[count];
        int k = 0;
        int start = 0;
        while(k < count) {
            int maxIdx = start;
            for (int i = start; i <= a.length - count + k; i++) {
                if (a[maxIdx] < a[i]) {
                    maxIdx = i;
                }
            }
            res[k++] = a[maxIdx];
            start = maxIdx+1;
        }
        return res;
    }

    public static int[] merge(int[] a, int[] b) {
        if (a.length == 0) return b;
        if (b.length == 0) return a;

        int res[] = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (isGreater(a, i, b, j)) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }

        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];
        return  res;
    }

    private static boolean isGreater(int[] a, int startA, int[] b, int startB) {
        while (startA < a.length && startB < b.length && a[startA] == b[startB]) {
            startA++;
            startB++;
        }
        if (startA >= a.length) return false;
        if (startB >= b.length) return true;
        return a[startA] > b[startB];
    }

}
