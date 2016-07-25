package tasks.dp;

public class PalindromePartition {


    public static int solve(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int l = 1; l < str.length(); l++) {
            for (int i = 0; i < str.length()-l; i++) {
                int j = i + l - 1;
                if (isPalindrome(str, i, j)) {
                    dp[i][j] = 0;
                } else {
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + 1);
                    }
                }
            }
        }
        return dp[0][str.length()-1];
    }

    private static boolean isPalindrome(String str, int start, int end) {
        int i = start;
        int j = end;
        while(i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
