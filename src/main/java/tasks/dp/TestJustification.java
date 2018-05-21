package tasks.dp;

public class TestJustification {

    public static int[] solve(int size, String[] words) {
        int[][] dp = new int[words.length][words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                int len = words[i].length();
                boolean ok = len <= size;
                for (int k = i+1; k <= j; k++) {
                    if (len + 1 + words[k].length() > size) {
                        ok = false;
                        break;
                    }
                    len += words[k].length() + 1;
                }
                dp[i][j] = ok ? (size - len) * (size - len) : Integer.MAX_VALUE;
                dp[j][i] = dp[i][j];
            }
        }

        int[] min = new int[words.length];
        int[] pos = new int[words.length];

        for (int i = words.length - 1; i >= 0; i--) {
            min[i] = dp[i][words.length-1];
            pos[i] = words.length;
            for (int j = words.length-1; j > i; j--) {
                if (dp[i][j-1] != Integer.MAX_VALUE) {
                    int s = min[j] + dp[i][j - 1];
                    if (s < min[i]) {
                        min[i] = s;
                        pos[i] = j;
                    }
                }
            }
        }
        return pos;
    }

}
