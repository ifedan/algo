package algos.sort;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class HeapSort {
    
    public static void sort(int[] a) {
        int n = a.length - 1;

        for(int i=n/2; i>=0; i--){
            sink(a, i, n);
        }

        for(int i=n; i>=0; i--) {
            exch(a, 0, i);
            sink(a, 0, --n);
        }
    }

    private static void sink(int[] a, int parent, int n) {
        int left, right, largest;
        while ((left = 2*parent) <= n) {
            right = left + 1;

            if (left <= n && a[left] > a[parent]) {
                largest = left;
            } else {
                largest = parent;
            }

            if (right <= n && a[right] > a[largest]) {
                largest = right;
            }

            if (largest == parent) break;
            exch(a, parent, largest);
            parent = largest;
        }
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
