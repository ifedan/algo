package tasks.recursion;

public class LongestPalindromicSubsequence {

    public static int solve(char[] str, int start, int len) {

        if (len == 1) {
            return 1;
        }

        if (len == 0) {
            return 0;
        }

        if (str[start] == str[start+len-1]) {
            return 2 + solve(str, start+1, len-2);
        } else {
            return Math.max(solve(str, start+1, len-1), solve(str, start, len-1));
        }
    }

}
