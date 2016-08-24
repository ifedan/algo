package tasks.leetcode;

public class ReverseInteger {

    public static int reverseInteger(int x) {
        int sign = x < 0 ? -1 : 1;
        long y = 0;
        x = Math.abs(x);
        while (x > 0) {
            y *= 10;
            y += x % 10;
            x = x / 10;
            if( y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
                return 0;
        }
        return (int)y * sign;
    }

}
