package algos.sort;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class LSD {

    //a - number form 0, 9
    private static void sort(int[] a) {
        int[] rang = new int[10+1];
        for (int i = 0; i < a.length; i++) {
            rang[a[i]+1]++;
        }
        for (int i = 1; i < 10 + 1; i++) {
            rang[i] = rang[i] + rang[i-1];
        }
        int aux[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            aux[rang[a[i]]++] = a[i];
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i]^aux[i];
            aux[i] = a[i]^aux[i];
            a[i] = a[i]^aux[i];
        }
    }
}
