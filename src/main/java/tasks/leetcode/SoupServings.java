package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SoupServings {

    public double soupServings(int N) {
        return N >= 4800 ?  1.0 : solve(N, N, 1, new HashMap<>());
    }

    public double solve(int a, int b, double prob, Map<Long, Double> cache) {
        if (a <= 0 && b > 0) {
            return prob;
        }
        if (a <= 0) {
            return prob * 0.5;
        }
        if (b <= 0) {
            return 0;
        }
        long key = (((long)a)<<31) | b;
        Double d = cache.get(key);
        if (d != null) return d;
        double res = solve(a-100, b, prob * 0.25, cache) +
                solve(a-75, b-25, prob * 0.25, cache) +
                solve(a-50, b-50, prob * 0.25, cache) +
                solve(a-25, b-75, prob * 0.25, cache);
        cache.put(key, res);
        return res;
    }
}
