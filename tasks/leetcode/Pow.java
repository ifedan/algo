package tasks.leetcode;

public class Pow {

    public double myPow(double x, int n) {
        if (x == 1) return 1;
        if (x == 0) return n == 0 ? 1 : 0;
        if (x == -1) return n % 2 == 0 ? 1 : -1;

        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;

        return pow(x, n);
    }

    public static double pow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return 1 / pow(x, 0 - n);
        if (n % 2 == 0) return pow(x * x, n / 2);
        else return pow(x * x, n / 2) * x;

    }
}
