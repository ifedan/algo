package algos.sort;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class MergeSort {

    private static void merge(int[] a, int[] aux, int lo, int hi, int mid) {
        for (int k = lo; k <= hi; k++) {
            aux[k]=a[k];
        }
        int i = 0;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                a[k] = a[j++];
            } else if (aux[i] <= aux[j]) {
                a[k] = a[i++];
            }
        }
    }

    public static void sort(int a[]) {
        int aux[] = new int[a.length];
        for (int hs = 1; hs < a.length; hs = (hs + hs)) {
            for (int lo = 0; lo < a.length - hs; lo = lo + (hs + hs)) {
                int mid = lo + hs - 1;
                int hi = Math.min(lo + hs + hs - 1, a.length - 1);     //TODO: High index it's a min of high and length
                merge(a, aux, lo, hi, mid);
            }
        }
    }

}
