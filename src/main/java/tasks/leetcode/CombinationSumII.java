package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < candidates.length; i++) {
            Integer count = map.get(candidates[i]);
            if (count == null) {
                map.put(candidates[i], 1);
            } else {
                map.put(candidates[i], count+1);
            }
        }
        int nums[] = new int[map.size()];
        int count[] = new int[map.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[k] = entry.getKey();
            count[k] = entry.getValue();
            k++;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationSum2(nums, count, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void combinationSum2(int[] nums, int[] count, int start, int target, List<Integer> output, List<List<Integer>> result) {
        if (target < 0) return;

        if (target == 0) {
            result.add(new ArrayList<Integer>(output));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            output.add(nums[i]);
            count[i]--;
            combinationSum2(nums, count, i, target - nums[i], output, result);
            count[i]++;
            output.remove(output.size()-1);
        }
    }

}
