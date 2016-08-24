package tasks.leetcode;

public class NumberOf1Bits {

    public static int hammingWeight(int n) {
        int i = 0;
        int res = 0;
        while (i < 32) {
            res += (n&1);
            n = n >> 1;
            i++;
        }
        return res;
    }

}
