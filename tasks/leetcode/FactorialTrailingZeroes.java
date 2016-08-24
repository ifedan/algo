package tasks.leetcode;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int val = 5;
        int res = n / 5;
        int sum = res;
        while (res > 1) {
            val *= 5;
            res = n / val;
            sum += res;

        }
        return sum;
    }

}
