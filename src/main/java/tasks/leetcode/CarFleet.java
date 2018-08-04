package tasks.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;
        int count = position.length;
        int[][] arr = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, Comparator.comparing(a -> a[0]));

        int base = position.length - 1;
        for (int i = position.length - 2; i >= 0; i--) {
            double t1 = ((double)(target - arr[base][0])) / arr[base][1];
            double t2 = ((double)(target - arr[i][0])) / arr[i][1];
            if (t1 >= t2) {
                count--;
            } else {
                base = i;
            }
        }
        return count;
    }

    /*
    0, 2, 4  -> 10
    2, 3, 1
     */

    public static void main(String[] args) {
        int result = carFleet(10, new int[] {0,4,2}, new int[]{2,1,3});
        System.out.println(result);
    }
}
