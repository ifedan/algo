package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationSum3(k, n, 1, new ArrayList<Integer>(), result);
        return result;
    }

    public static void combinationSum3(int k, int n, int start, List<Integer> output, List<List<Integer>> result) {
        if (n < 0) return;
        if (n == 0) {
            if (output.size() != k) return;
            result.add(new ArrayList<Integer>(output));
            return;
        }

        for (int i = start; i <= 9; i++) {
            output.add(i);
            combinationSum3(k, n-i, i+1, output, result);
            output.remove(output.size()-1);
        }
    }

}
