package tasks.leetcode;

import java.util.*;

public class RepeatedDNASequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        int len = 10;
        List<String> result = new ArrayList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        Set<Integer> added = new HashSet<>();

        int curr = hash(s, 0, len);
        hash.put(curr, 0);
        for (int i = 1; i <= s.length()-len; i++) {
            int next = rehash(s, i+len-1, curr);

            Integer index = hash.get(next);

            //System.out.println(i + " " + s.substring(i, i+len) + " - " + next + "    same:" + index);

            if (index != null && i - index >= len && !added.contains(next)) {
                String seq = s.substring(i, i+len);
                added.add(next);
                result.add(seq);
            }
            hash.put(next, i);
            curr = next;
        }
        return result;
    }

    private static int MASK = Integer.parseInt("00111111111111111111", 2);

    public static int hash(String s, int start, int end) {
        int hash = 0;
        for (int i = start; i < end; i++) {
            hash = hash << 2;
            if ('C' == s.charAt(i)) {
                hash = hash | 1;
            } else if ('G' == s.charAt(i)) {
                hash = hash | 2;
            } else if ('T' == s.charAt(i)) {
                hash = hash | 3;
            }
        }
        return hash;
    }

    public static int rehash(String s, int next, int hash) {
        hash = hash & MASK;
        hash = hash << 2;
        if ('C' == s.charAt(next)) {
            hash = hash | 1;
        } else if ('G' == s.charAt(next)) {
            hash = hash | 2;
        } else if ('T' == s.charAt(next)) {
            hash = hash | 3;
        }
        return hash;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        /*int h = hash("AAAAACCCCC", 0, 10);
        System.out.println(Integer.toBinaryString(h));
        System.out.println(h);
        System.out.println(rehash("AAAAAACCCCC", 10, h));*/
    }

}
