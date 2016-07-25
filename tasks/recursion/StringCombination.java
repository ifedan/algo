package tasks.recursion;

import java.util.*;

public class StringCombination {

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
        solve(chars, counts, 0, new char[input.length], 0, results);
        return results;
    }

    private static void solve(char[] chars, int[] counts, int start, char[] output, int len, Collection<String> results) {
        results.add(new String(output, 0, len));
        for (int i = start; i<chars.length; i++) {
            if (counts[i] <= 0) {
                continue;
            }

            counts[i]--;
            output[len] = chars[i];
            solve(chars, counts, i, output, len+1, results);
            counts[i]++;

        }
    }

    public static void main(String[] args) {
        System.out.println(solve("AABC".toCharArray()));
    }

}
