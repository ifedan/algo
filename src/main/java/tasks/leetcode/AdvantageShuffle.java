package tasks.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class AdvantageShuffle {
    public static int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Long> counter = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            counter.merge(A[i], 1L, (val, acc) -> val + acc);
        }
        for (int i = 0; i < B.length; i++) {
            Map.Entry<Integer, Long> heigher = counter.higherEntry(B[i]);
            if (heigher != null) {
                A[i] = heigher.getKey();
                counter.compute(A[i], (k, v) -> v == 1 ? null : v - 1);
            }
        }
        return A;
    }
}
