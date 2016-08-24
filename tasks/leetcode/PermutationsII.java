package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], count+1);
            }
        }
        int vals[] = new int[map.size()];
        int count[] = new int[map.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            vals[k] = entry.getKey();
            count[k] = entry.getValue();
            k++;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteUnique(vals, count, nums.length, new ArrayList<Integer>(), result);
        return result;
    }

    public static void permuteUnique(int[] nums, int[] count, int total, List<Integer> output, List<List<Integer>> result) {
        if (total == 0) {
            result.add(new ArrayList<Integer>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 0) continue;

            count[i]--;
            output.add(nums[i]);
            permuteUnique(nums, count, total-1, output, result);
            output.remove(output.size()-1);
            count[i]++;
        }
    }
}
