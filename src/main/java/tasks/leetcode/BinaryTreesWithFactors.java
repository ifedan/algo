package tasks.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors {
    public static int numFactoredBinaryTrees(int[] A) {
        if (A.length < 2) return A.length;
        Arrays.sort(A);
        int mod = 1000000007;
        Map<Integer, Long> dp = new HashMap<>();
        long total = 0;
        for (int i = 0; i < A.length; i++) {
            long count = 1;
            for (Map.Entry<Integer, Long> entry : dp.entrySet()) {
                if (A[i] % entry.getKey() == 0) {
                    int div = A[i] / entry.getKey();
                    if (dp.containsKey(div)) {
                        count += dp.get(div) * entry.getValue();
                    }
                }
            }
            dp.put(A[i], count);
            total = (total + count) % mod;
        }
        return (int) total;
    }
}
