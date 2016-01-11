package algos.sort;

import java.util.LinkedList;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class RadixSort {

    public static void lcs(int a[], int maxLength, int optionCount) {
        int d = 1;
        while (d <= maxLength) {
            int[] count = new int[optionCount];
            int[] copy = new int[a.length];

            for (int i = 0; i < a.length; i++) {
                int n = getValueAt(a[i], d);
                count[n]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i-1];
            }

            for (int i = a.length - 1; i>=0; i--) {
                int n = getValueAt(a[i], d);
                copy[count[n]-1] = a[i];
                count[n]--;
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = copy[i];
            }
            d++;
        }
    }
    
    private static void mcs(String[] a, int maxLength, int optionCount) {
        int d = maxLength;
        while (d >= 0) {
            int[] count = new int[optionCount];
            String[] copy = new String[a.length];

            for (int i = 0; i < a.length; i++) {
                int n = getValueAt(a[i], d);
                count[n]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i-1];
            }

            for (int i = a.length - 1; i>=0; i--) {
                int n = getValueAt(a[i], d);
                copy[count[n]-1] = a[i];
                count[n]--;
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = copy[i];
            }
            d--;
        }
    }
    
    private static int getValueAt(int a, int pos) {
        int d = (int) Math.pow(10, pos);
        return (a/d)%10;
    }

    private static int getValueAt(String a, int pos) {
        return a.length() <= pos ? 0 : a.charAt(pos) - 'a';
    }

}
