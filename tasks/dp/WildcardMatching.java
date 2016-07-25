package tasks.dp;

public class WildcardMatching {

    public static boolean solve(String str, String prefix) {
        boolean dp[][] = new boolean[str.length()][prefix.length()];
        dp[0][0] = true;

        for (int i = 1; i < prefix.length(); i++) {
            if (prefix.charAt(i-1) == '?') {
                dp[0][1] = true;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; i++) {
                if (str.charAt(i-1) == prefix.charAt(j-1) || prefix.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (prefix.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[str.length()][prefix.length()];
    }

}
