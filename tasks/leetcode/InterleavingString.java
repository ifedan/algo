package tasks.leetcode;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;


        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1)) {
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int i = 1; i <= s2.length(); i++) {
            if (s2.charAt(i-1) == s3.charAt(i-1)) {
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int index = (i+j-1);
                if (s3.charAt(index) == s1.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j];
                }
                if (!dp[i][j] && s3.charAt(index) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
