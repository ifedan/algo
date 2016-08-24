package tasks.leetcode;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        int pivot = x;
        if (x < 0) return false;
        int y = 0;
        while (x > 0) {
            y = y * 10;
            y += x % 10;
            x = x / 10;
        }
        return y == pivot;
    }

}
