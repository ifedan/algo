package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    public static List<String> wordBreak2(String s, Set<String> wordDict) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;

                if (wordDict.contains(new String(s.toCharArray(), i, len))) {
                    dp[i][j] = true;
                } else {
                    for (int k = i; k < j; k++) {
                        dp[i][j] = dp[i][j] | (dp[i][k] & dp[k+1][j]);
                        if (dp[i][j]) break;
                    }
                }
            }
        }


        List<String> result = new ArrayList<String>();
        wordBreak(s, 0, wordDict, dp, new ArrayList<String>(), result);
        return result;
    }

    public static void wordBreak(String s, int start, Set<String> wordDict, boolean[][] dp, List<String> output, List<String> result) {
        if (start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < output.size(); i++) {
                sb.append(output.get(i));
                if (i != output.size()-1) {
                    sb.append(' ');
                }
            }
            result.add(sb.toString());
            return;
        }
        for (int len = 1; len <= s.length()-start; len++) {
            String str = new String(s.toCharArray(), start, len);
            if (!wordDict.contains(str) || (start+len < s.length() && !dp[start+len][s.length()-1])) {
                continue;
            }
            else {
                output.add(str);
                wordBreak(s, start+len, wordDict, dp, output, result);
                output.remove(output.size()-1);
            }
        }
    }


}
