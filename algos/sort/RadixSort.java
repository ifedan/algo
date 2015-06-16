package algos.sort;

import java.util.LinkedList;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class RadixSort {


    public static void sort(int a[]) {
        LinkedList<Integer>[] buckets = new LinkedList[10];
        int d = 1;

        boolean flag = true;
        while (flag) {

            flag = false;

            for (int i = 0; i < a.length; i++) {
                int hashIndex = (a[i]/d)%10;
                if (hashIndex > 0) {   //TODO: CONTINUE UNTIL ALL NUMBERS IN 0-bucket
                    flag = true;
                }
                if (buckets[hashIndex] == null) {
                    buckets[hashIndex] = new LinkedList<Integer>();
                }
                buckets[hashIndex].add(a[i]);
            }

            int k = 0;
            for (LinkedList<Integer> ll : buckets) {
                if (ll == null) continue;
                while (!ll.isEmpty()) {
                    a[k++] = ll.removeFirst();
                }
            }

            d = d * 10;
        }

    }

}
