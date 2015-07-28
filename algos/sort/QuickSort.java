package algos.sort;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class QuickSort {

    public static void sort(int a[]) {
        sort(a, 0, a.length - 1);
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
            swap(a, hi, l);

            sort(a, lo, l-1);
            sort(a, l+1, hi);
        }
    }
    
    private static void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }



}
