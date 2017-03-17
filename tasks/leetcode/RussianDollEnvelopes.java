package tasks.leetcode;

import java.util.Arrays;

public class RussianDollEnvelopes {
  public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        int[] max = new int[envelopes.length];
        Arrays.sort(envelopes, (a, b)->a[1]-b[1]);

        int res = 0;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                    res = Math.max(res, max[i]);
                } else if (envelopes[i][1] == envelopes[j][1]) break;
            }
        }
        return res+1;
    }
}
