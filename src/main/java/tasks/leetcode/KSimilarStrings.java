package tasks.leetcode;

import java.util.*;

public class KSimilarStrings {

    public static void main(String[] args) {
        int res = kSimilarity("abcac", "aaccb");
        System.out.println(res);
    }

    public static int kSimilarity(String A, String B) {
        Map<Character, Set<Integer>> positions = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                final int pos = i;
                positions.compute(B.charAt(i), (k, v) -> {
                    if (v == null) v = new HashSet<>();
                    v.add(pos);
                    return v;
                });
            }
        }
        return bfs(A.toCharArray(), B.toCharArray(), 0, positions, 0);
    }

    private static int bfs(char[] s1, char[] s2, int pos, Map<Character, Set<Integer>> positions, int swaps) {
        if (pos == s1.length) {
            return swaps;
        }
        if (s1[pos] == s2[pos]) {
            return bfs(s1, s2, pos+1, positions, swaps);
        }
        Set<Integer> positionSet = positions.get(s1[pos]);
        List<Integer> positionList = new ArrayList<>(positionSet);
        int min = Integer.MAX_VALUE;
        for (int replaceIndex : positionList) {
            if (replaceIndex <= pos) {
                continue;
            }

            swap(s2, pos, replaceIndex); //on pos there are same characters
            positionSet.remove(replaceIndex); //on replaceIndex become other character
            if (s2[replaceIndex] != s1[replaceIndex]) {
                positions.get(s2[replaceIndex]).add(replaceIndex);
            }

            int res = bfs(s1, s2, pos+1, positions, swaps+1);
            min = Math.min(min, res);

            swap(s2, pos, replaceIndex);
            positionSet.add(replaceIndex);
            positions.get(s2[pos]).remove(replaceIndex);
        }
        return min;
    }

    private static void swap(char[] s, int i1, int i2) {
        char t = s[i1];
        s[i1] = s[i2];
        s[i2] = t;
    }
}
