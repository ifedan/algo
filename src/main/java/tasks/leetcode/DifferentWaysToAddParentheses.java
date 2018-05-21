package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input, new HashMap<String, List<Integer>>());
    }

    public List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> cache) {
        if (cache.containsKey(input)) {
            return cache.get(input);
        }

        boolean expr = false;
        List<Integer> result =new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if ("+-*".indexOf(input.charAt(i)) >= 0) {
                expr = true;
                List<Integer> left = diffWaysToCompute(input.substring(0, i), cache);
                List<Integer> right = diffWaysToCompute(input.substring(i+1), cache);
                for (Integer l : left) {
                    for (Integer r : right) {
                        result.add(calc(l, r, input.charAt(i)));
                    }
                }
            }
        }
        if (!expr) {
            result.add(Integer.parseInt(input));
        }
        cache.put(input, result);
        return result;

    }

    private Integer calc(int i, int j, char op) {
        if (op == '+') return i+j;
        if (op == '-') return i-j;
        if (op == '*') return i*j;
        throw new IllegalStateException();
    }

}
