package tasks.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        Arrays.stream(nums).forEach(a -> counter.merge(a, 1, (x, y) -> x + y));
        List<Integer> result = new ArrayList<>();
        while (k > 0) {
            int key = -1;
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    key = entry.getKey();
                }
            }
            counter.remove(key);
            result.add(key);
            k--;
        }

        return result;
    }
}
