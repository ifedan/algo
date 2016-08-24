package tasks.leetcode;

public class ReverseBits {

    public static int reverse(int x) {
        int i = 0;
        int res = 0;
        while (i < 32) {
            res = res << 1;
            int last = x & 1;
            res = res | last;
            x = x >> 1;
            i++;
        }
        return res;
    }

}
