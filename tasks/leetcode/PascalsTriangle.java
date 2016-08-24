package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        if (numRows == 1) {
            return result;
        }
        generate(first, numRows, result);

        System.out.println(result);
        return result;
    }

    public static void generate(List<Integer> prev, int n, List<List<Integer>> result) {
        int[] t = new int[prev.size() + 1];
        t[0] = 1;
        t[t.length - 1] = 1;

        int i = 1;
        while(t[i] != 1) {
            t[i] = prev.get(i) + prev.get(i-1);
            i++;
        }
        List<Integer> row = new ArrayList<>();
        for (int j = 0; j < t.length; j++) {
            row.add(t[j]);
        }
        result.add(row);
        if (n == 2) {
           return;
        }
        generate(row, n-1, result);
    }

    public static void main(String[] args) {
        generate(5);
    }


}
