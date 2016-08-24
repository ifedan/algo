package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        permute(list, new ArrayList<Integer>(), result);
        return result;
    }

    public static void permute(List<Integer> nums, List<Integer> output, List<List<Integer>> result) {
        if (nums.isEmpty()) {
            result.add(new ArrayList<Integer>(output));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            output.add(nums.get(i));
            nums.remove(i);
            permute(nums, output, result);
            int val = output.remove(output.size()-1);
            nums.add(i, val);
        }
    }
}
