package tasks.dp;

import java.util.Set;

public class WorldBreak {

    public static boolean solve(String str, Set<String> words) {
        boolean dp[][] = new boolean[str.length()][str.length()];
        for (int l = 1; l < str.length(); l++) {
            for (int i = 0; i < str.length() - l; i++) {
                int j = i + l - 1;

                if (words.contains(str.substring(i, j))) {
                    dp[i][j] = true;
                } else {
                    for (int k = i+1; k < j; k++) {
                        dp[i][j] = dp[i][k] && dp[k][j];
                        if (dp[i][j]) break;
                    }
                }

            }
        }
        return dp[0][str.length()-1];
    }

}
