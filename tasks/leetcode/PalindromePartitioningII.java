package tasks.leetcode;

public class PalindromePartitioningII {

    public static int minCut(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i <= j+1 || dp[i-1][j+1])) {
                    dp[i][j] = true;
                    min = Math.min(min, j == 0 ? 0 : 1 + cut[j-1]);
                }
            }
            cut[i] = min;
        }
        return cut[s.length()-1];
    }



    public static void main(String[] args) {

    }
}
