package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        return solve(A, B, 0, 0, new HashMap<>());
    }

    /*
    new int[]{0,4,4,5,9}, new int[]{0,1,6,8,10}
     */

    private static int solve(int[] a, int[] b, int pos, int count, Map<String, Integer> cache) {
        if (pos >= a.length) {
            return count;
        }
        //long key = (((long)pos)<<31) | a[pos];
        String key = pos + "|" + a[pos] + "|" + (pos == 0 ? "X" : a[pos-1]);
        Integer cached = cache.get(key);
        if (cached != null) {
            return count + cached;
        }
        int min = Integer.MAX_VALUE;
        if (pos == 0 || (a[pos] > a[pos-1] && b[pos] > b[pos-1])) {
            int res1 = solve(a, b, pos + 1, count, cache);
            //System.out.println("pos = " + pos + " res1 = " + res1);
            min = Math.min(min, res1);
        }
        if (a[pos] != b[pos] && (pos == 0 || (b[pos] > a[pos-1] && a[pos] > b[pos-1]))) {
            swap(a, b, pos);
            int res2 = solve(a, b, pos + 1, count + 1, cache);
            //System.out.println("pos = " + pos + " res2 = " + res2);
            min = Math.min(min, res2);
            swap(a, b, pos);
        }
        cache.put(key, min - count);
        return min;
    }

    private static void swap(int[] a, int[] b, int pos) {
        int t = a[pos];
        a[pos] = b[pos];
        b[pos] = t;
    }
}
