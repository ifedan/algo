package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void subsets(int[] nums, int start, List<Integer> output, List<List<Integer>> result) {
        result.add(new ArrayList<>(output));
        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            output.add(nums[i]);
            subsets(nums, i+1, output, result);
            output.remove(output.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }


}
