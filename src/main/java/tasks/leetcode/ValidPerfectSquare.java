package tasks.leetcode;

public class ValidPerfectSquare {
    //Newton's method: x1 = x0 + f(x0)/f'(x0)
    //f(x) = x^2 - A
    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x*x > num) {
            x = (x + num/x)/2;
        }
        return x*x == num;
    }

}
