package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSumOfAverages {

    public static void main(String[] args) {
        double res = largestSumOfAverages(new int[]{1,2,3,4,5,6,7}, 4);
        System.out.println(res);
    }

    public static double largestSumOfAverages(int[] A, int K) {
        double[] sum = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            sum[i] = i == 0 ? A[i] : sum[i-1] + A[i];
        }
        return compute(A, new ArrayList<>(), K-1, sum, 0, new HashMap<>(), new HashMap<>());
    }

    public static double compute(int[] A, List<Integer> seqIndex, int k, double[] sum, double avgSum, Map<Long, Double> cache, Map<String, Double> maxCache) {
        if (seqIndex.size() == k) {
             double res =  avgSum + calc(seqIndex.size(), A, seqIndex, sum, cache);
             //System.out.println(seqIndex + " --> " + res);
             return res;
        }
        int last = seqIndex.isEmpty() ? -1 : seqIndex.get(seqIndex.size() - 1);

        String key = last + "|" + seqIndex.size();
        Double cached = maxCache.get(key);
        if (cached != null) {
            double res = cached + avgSum;
            //System.out.println(seqIndex + " >> " + res);
            return res;
        }

        double max = 0;
        int maxIndex = A.length - (k - seqIndex.size());
        for (int i = last + 1; i < maxIndex; i++) {
            seqIndex.add(i);
            double avg = calc(seqIndex.size() - 1, A, seqIndex, sum, cache);
            max = Math.max(max, compute(A, seqIndex, k, sum, avgSum + avg, cache, maxCache));
            seqIndex.remove(seqIndex.size() - 1);
        }

        //System.out.println(seqIndex + " ==> " + max);

        maxCache.put(key, max - avgSum);

        return max;
    }

    private static double calc(int i, int[] A, List<Integer> seqIndex, double[] sum, Map<Long, Double> cache) {
        int x = i == 0 ? 0 : seqIndex.get(i-1) + 1;
        int y = i == seqIndex.size() ? A.length - 1 : seqIndex.get(i);
        long key = (((long)x) << 31) | y;
        Double cached = cache.get(key);
        if (cached != null) {
            return cached;
        }
        double avg = (A[x] + sum[y] - sum[x]) / (y - x + 1);
        cache.put(key, avg);
        return avg;
    }
}
