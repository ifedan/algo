package tasks.leetcode;

import java.util.*;

public class ReorderedPowerOf2 {
    public static boolean reorderedPowerOf2(int N) {
        if (N == 1) return true;
        if (N == 2) return true;
        if (N == 4) return true;
        if (N == 8) return true;
        return powers().contains(toKey(N));
    }

    private static Set<String> powers() {
        Set<String> set = new HashSet<>();
        for (int i = 4; i < 31; i++) {
            set.add(toKey(1 << i));
        }
        return set;
    }

    private static String toKey(int a) {
        List<Integer> list = new ArrayList<>();
        while (a > 0) {
            int n = a%10;
            list.add(n);
            a = a/10;
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(powers());
    }
}
