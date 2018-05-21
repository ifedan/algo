package algos.sort;

public class MergeSort {

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length);
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi-lo > 1) {
            int mid = (hi-lo)/2 + lo;

            sort(a, aux, lo, mid);
            sort(a, aux, mid, hi);

            for (int i = lo; i < hi; i++) {
                aux[i] = a[i];
            }

            int i = lo;
            int j = mid;
            int k = lo;
            while (k < hi) {
                if ((i < mid && j < hi && aux[i] < aux[j]) || j >= hi) {
                    a[k++] = aux[i++];
                } else {
                    a[k++] = aux[j++];
                }
            }
        }
    }

}
