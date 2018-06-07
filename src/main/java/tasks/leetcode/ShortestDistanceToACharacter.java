package tasks.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToACharacter {
    public static int[] shortestToChar(String S, char C) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                list.add(i);
            }
        }
        int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                result[i] = 0;
            } else {
                result[i] = binarySearch(list, i);
            }
        }
        return result;
    }

    private static int binarySearch(List<Integer> list, int value) {
        int i = 0;
        int j = list.size() - 1;

        while (i <= j) {
            int mid = i + (j-i)/2;
            if (list.get(mid) > value) {
                j = mid - 1;
            } else if (list.get(mid) < value) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        if (i < 0) i = 0;
        if (j < 0) j = 0;
        if (i >= list.size()) i = list.size() - 1;
        if (j >= list.size()) j = list.size() - 1;

        return Math.min(Math.abs(list.get(i) - value), Math.abs(list.get(j) - value));
    }

    public static void main(String[] args) {
        int[] arr = shortestToChar("loveleetcode", 'e');
        System.out.println(Arrays.toString(arr));
    }
}
