package tasks.recursion;

import java.util.HashMap;
import java.util.Map;

public class Knapsack01 {

    public static int solve(int[] weight, int[] value, int total) {
        return solve(0, weight, value, total, new HashMap<>());
    }

    private static int solve(int current, int[] weight, int[] value, int total, Map<Long, Integer> cache) {
        if (current == weight.length || total <= 0) {
            return 0;
        }

        int remainingItems = weight.length - current - 1;
        long key = ((long)remainingItems << 32) | (long)total;
        Integer cached = cache.get(key);
        if (cached != null) {
            return cached;
        }

        int max;
        if (total < weight[current]) {
            max = solve(current+1, weight, value, total, cache);
        } else {
            max = Math.max(
                    solve(current+1, weight, value, total-weight[current], cache) + value[current],
                    solve(current+1, weight, value, total, cache)
            );
        }
        cache.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        int[] weight = new int[]{2, 2, 4, 5};
        int[] value = new int[]{2, 4, 6, 9};
        System.out.println(solve(weight, value, 8));
    }

}
