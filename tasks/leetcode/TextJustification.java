package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int dp[][] = new int[words.length][words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += words[k].length();
                    if (k != j) {
                        sum += 1;
                    }
                    if (sum > maxWidth) {
                        sum = Integer.MAX_VALUE;
                        break;
                    }
                }
                if (sum == Integer.MAX_VALUE) {
                    dp[i][j] = sum;
                } else {
                    dp[i][j] = (int)Math.pow(maxWidth - sum, 2);
                }
            }
        }

        int[] sum = new int[words.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = Integer.MAX_VALUE;
        }
        int[] pos = new int[words.length];

        for (int i = words.length - 1; i >= 0; i--) {
            if (dp[i][words.length-1] != Integer.MAX_VALUE) {
                sum[i] = dp[i][words.length-1];
                pos[i] = words.length;
                continue;
            }

            for (int j = words.length - 2; j >= i; j--) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int newSum = dp[i][j] + sum[j+1];
                if (sum[i] > newSum) {
                    sum[i] = newSum;
                    pos[i] = j+1;
                }
            }
        }

        List<String> result = new ArrayList<>();
        int next = 0;
        while (next < words.length) {
            String line = "";
            for (int i = next; i < pos[next]; i++) {
                line += words[i];
                if (i != pos[next] - 1) {
                    line += " ";
                }
            }
            while (line.length() < maxWidth) {
                line += " ";
            }
            result.add(line);
            if (pos[next] == next) break;
            next = pos[next];
        }

        return result;
    }

    public static void main(String[] args) {
        fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."}, 6);
    }

}
