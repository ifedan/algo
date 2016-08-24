package tasks.leetcode;

public class TestPalindromePartitioning {

    public static int minCuts(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrom(s, i, j)) {
                    dp[i][j] = 0;
                } else {
                    int min = 1;
                    for (int k = i+1; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k][j] + 1);
                    }
                }

            }
        }
        return dp[0][s.length()-1];
    }

    private static boolean isPalindrom(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

}
