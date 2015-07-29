package algos.sort;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class HeapSort {

    private static void sink(int[] a, int i, int n) {
        while (2*i <= n) {
            int left = 2 * i;
            int right = 2 * i + 1;
            int largest;

            if (left <= n && a[left] > a[i]) {
                largest = left;
            } else {
                largest = i;
            }

            if (right <= n && a[right] > a[largest]) {
                largest = right;
            }

            if (largest == i) break;
            exch(a, i, largest);
            i = largest;
        }
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
