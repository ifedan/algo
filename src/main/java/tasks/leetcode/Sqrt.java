package tasks.leetcode;

public class Sqrt {

    public static int mySqrt(int x) {
        double x0 = x;
        while (Math.abs((x0 * x0) - x) > 0.00001) {
            x0 = ((x0*x0 + x)/(2*x0));
        }
        return (int) x0;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }

}
