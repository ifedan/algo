package tasks.leetcode;

public class SumOfTwoIntegers {
  private static int getPositiveSum(int a, int b) {
        int pos = 1;
        int res = 0;
        boolean extra = false;

        while (pos != 0) {
            int d1 = a & 1;
            int d2 = b & 1;

            if (extra && (d1^d2) == 0) {
                res |= pos;
                if ((d1&d2) == 0) extra = false;
            }
            else if (!extra && (d1^d2) == 1) {
                res |= pos;
            } else if (!extra && (d1&d2) == 1) {
                extra = true;
            }
            a >>=1;
            b >>=1;
            pos <<= 1;
        }
        return res;
    }
  
}
