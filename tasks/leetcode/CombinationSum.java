package tasks.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, result, target, new ArrayList<Integer>());
        return result;
    }

    private static void combinationSum(int[] c, int start, List<List<Integer>> result, int target, List<Integer> comb) {
        if (target < 0) return;

        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < c.length; i++) {
            comb.add(c[i]);
            combinationSum(c, i, result, target-c[i], comb);
            comb.remove(comb.size()-1);
        }

    }

}
