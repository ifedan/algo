package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StrobogrammaticNumberII {
    public static List<String> findStrobogrammatic(int n) {
        if (n == 1) {
            return Stream.of("1", "8", "0").collect(Collectors.toList());
        }
        int sizeToGenerate = n/2;
        List<List<Integer>> permuts = new ArrayList<>();
        permutation(new int[]{0, 1, 6, 8, 9}, new ArrayList<>(), permuts, sizeToGenerate);

        List<String> result = new ArrayList<>();
        boolean generateMid = n%2 != 0;
        for (List<Integer> p : permuts) {
            result.addAll(toString(p, generateMid));
        }

        return result;
    }

    private static List<String> toString(List<Integer> list, boolean withMid) {
        int[] arr = new int[list.size()];
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 6) {
                arr[i] = 9;
            } else if (list.get(i) == 9) {
                arr[i] = 6;
            } else {
                arr[i] = list.get(i);
            }
            sb1.append(list.get(i));
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            sb2.append(arr[i]);
        }

        List<String> result = new ArrayList<>();
        if (withMid) {
            result.add(sb1 + "0" + sb2);
            result.add(sb1 + "1" + sb2);
            result.add(sb1 + "8" + sb2);
        } else {
            result.add(sb1.toString() + sb2);
        }
        return result;
    }

    private static void permutation(int[] nums, List<Integer> output, List<List<Integer>> result, int size) {
        if (output.size() == size) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int num : nums) {
            if (output.isEmpty() && num == 0) {
                continue;
            }
            output.add(num);
            permutation(nums, output, result, size);
            output.remove(output.size() - 1);
        }
    }

    public static void main(String[] args) {
        findStrobogrammatic(2);
    }
}
