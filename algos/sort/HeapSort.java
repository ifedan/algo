package algos.sort;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class HeapSort {

    public static void sort(int a[]) {
        for (int i = a.length/2; i >= 1; i--) {  //TODO: Reverse order
            sink(a, i, a.length);
        }
        int n = a.length;
        while (n > 1) {
            a[0] = a[0]^a[n-1];
            a[n-1] = a[0]^a[n-1];
            a[0] = a[0]^a[n-1];
            n--;
            sink(a, 1, n);  //TODO: FIRST
        }
    }

    private static void sink(int a[], int p, int n) {
        while (2*p <= n) {
            int c = 2*p;
            if (c < n && a[c-1] < a[c]) c++;
            if (!(a[p-1] < a[c-1])) break;
            int tmp = a[p-1];
            a[p-1] = a[c-1];
            a[c-1] = tmp;
            p = c;
        }
    }

}
