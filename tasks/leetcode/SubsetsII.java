package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], count+1);
            }
        }

        int[] vals = new int[map.size()];
        int count[] = new int[map.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            vals[k] = entry.getKey();
            count[k] = entry.getValue();
            k++;
        }
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDup(vals, count, 0, new ArrayList<>(), result);
        return result;
    }

    public static void subsetsWithDup(int[] nums, int[] count, int start, List<Integer> output, List<List<Integer>> result) {

        result.add(new ArrayList<>(output));

        for (int i = start; i < nums.length; i++) {
            if (count[i] == 0) {
                continue;
            }

            count[i]--;
            output.add(nums[i]);
            subsetsWithDup(nums, count, i, output, result);
            count[i]++;
            output.remove(output.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }

}
