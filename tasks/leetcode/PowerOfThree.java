package tasks.leetcode;

public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        if (n == 1) return true;
        int p = (int) Math.ceil(Math.log(n) / Math.log(3));
        return n == Math.pow(3, p);
    }
}
