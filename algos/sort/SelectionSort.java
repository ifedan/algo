package algos.sort;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class SelectionSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int c = a[i];
            a[i] = a[minIndex];
            a[minIndex] = c;
        }
    }

}
