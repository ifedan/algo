package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private static void combine(int n, int k, int start, List<Integer> output, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(output));
            return;
        }

        for (int i = start; i <= n; i++) {
            output.add(i);
            combine(n, k-1, i+1, output, result);
            output.remove(output.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

}
