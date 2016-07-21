package tasks.dp;

public class LongestCommonSubstring {

    public static int solve(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return 0;

        int[][] dp = new int[str1.length()+1][str1.length()+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

}
