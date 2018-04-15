package tasks.leetcode;

public class NumberOfDigitOne {

    public static int countDigitOne(int n) {
        int digit = n % 10;
        return calc(digit > 0 ? 1 : 0, 1, n / 10, digit, 10);
    }

    private static int calc(int sum, int func, int curr, int mod, int rank) {
        if (curr == 0) return sum;
        int digit = curr % 10;
        int add;
        if (digit == 0) add = 0;
        else if (digit == 1) add = mod + 1;
        else add = rank;
        return calc (sum + digit * func + add, 10 * func + rank, curr / 10, digit * rank + mod, rank * 10);
    }

    public static void main(String[] args) {
        countDigitOne(110);
    }

}
