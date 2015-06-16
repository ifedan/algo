package algos.sort;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class QuickSort {

    private static void sort(int a[]) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int a[], int lo, int hi) {
        if (hi <= lo) return;  //TODO: !!!!!!!!
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(int a[], int lo, int hi) {
        int base = a[lo];

        int i = lo;
        int j = hi + 1;

        while (true) {
            while (a[++i]<=base) {
                if (i == hi) break;
            }
            while (a[--j]>base) {
                if (j==lo) break;
            }
            if (i>=j) break;

            a[i] = a[i]^a[j];
            a[j] = a[i]^a[j];
            a[i] = a[i]^a[j];
        }

        a[lo] = a[j];
        a[j] = base;

        return j;
    }



}
