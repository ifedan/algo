package tasks.leetcode;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long res = ((long)n-1) & n;
        return res == 0;
    }

}
