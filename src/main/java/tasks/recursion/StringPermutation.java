package tasks.recursion;

import java.util.*;

public class StringPermutation {

    public static Collection<String> solve(char[] input) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : input) {
            map.merge(c, 1, (a, b) -> a+b);
        }
        char[] chars = new char[map.size()];
        int[] counts = new int[map.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            chars[i] = entry.getKey();
            counts[i] = entry.getValue();
            i++;
        }

        List<String> results = new ArrayList<>();
        solve(chars, counts, 0, new char[input.length], results);
        return results;
    }


    private static void solve(char[] chars, int[] counts, int index, char[] output, Collection<String> results) {
        if (index == output.length) {
            results.add(new String(output));
        }
        for (int i = 0; i < chars.length; i++) {
            if (counts[i] == 0) continue;
            output[index] = chars[i];
            counts[i]--;
            solve(chars, counts, index+1, output, results);
            counts[i]++;
        }
    }

    public static void main(String[] args) {
        System.out.println(solve("AABC".toCharArray()));
    }

}
