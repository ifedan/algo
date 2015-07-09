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
        if (hi > lo) {
            int mid = (hi - lo) / 2 + lo;
            int i = lo;
            int j = hi;
            do {
                while (a[i] < a[mid]) i++;
                while (a[j] > a[mid]) j--;
                if (i<=j) {
                    swap(a, i++, j--);
                }
            } while (i<=j);
            sort(a, lo, j);
            sort(a, i, hi);
        }
    }
    
    private static void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }



}
