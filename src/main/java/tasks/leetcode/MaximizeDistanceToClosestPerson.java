package tasks.leetcode;

public class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
        maxDistToClosest(new int[]{1,0,0,1});
    }

    public static int maxDistToClosest(int[] seats) {
        int prev = -1;
        int max = Integer.MIN_VALUE;
        for (int n = 0; n < seats.length; n++) {
            if (seats[n] == 1) {
                if (prev == -1) {
                    max = n;
                    prev = n;
                } else {
                    int d = n - prev - 1;
                    int len = (d % 2 != 0) ? d/2 + 1 : d/2;
                    if (len > max) {
                        max = len;
                    }
                    prev = n;
                }
            }
        }
        if (seats.length - prev - 1 > max) {
            max = seats.length - prev - 1;
        }
        return max;
    }
    /*
          0123456789
    0001000100100000

     */
}
