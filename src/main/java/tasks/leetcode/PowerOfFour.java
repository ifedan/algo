package tasks.leetcode;

public class PowerOfFour {

    public static boolean isPowerOfFour(int num) {
        return (num&(num-1)) == 0 && ((31 - Integer.numberOfLeadingZeros(num)) & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(-4));
    }

}
