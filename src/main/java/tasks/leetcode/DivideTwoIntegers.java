package tasks.leetcode;

public class DivideTwoIntegers {

    public static int divide(int what, int on) {
        if (what < on) {
            return 0;
        }
        if (what == on) {
            return 1;
        }

        int d = on;
        int mask = 1;
        while (d <= what) {
            d <<= 1;
            mask <<= 1;
        }

        d >>= 1;
        mask >>= 1;


        int result = 0;
        while (d > 0) {
            if (what >= d) {
                what = what - d;
                result = result | mask;
            }
            d >>= 1;
            mask >>= 1;
        }

        return result;
    }

}
