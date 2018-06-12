package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLetterString {

    public static int uniqueLetterString(String S) {
        return (int)getUniqueLetterString(S) % 1000000007;
    }

    public static long getUniqueLetterString(String S) {
        Map<Character, List<Integer>> charMap = new HashMap<>(26);
        for (int i = 0; i < S.length(); i++) {
            int index = i;
            charMap.compute(S.charAt(i), (k, v) -> {
               if (v == null) v = new ArrayList<>();
               v.add(index);
               return v;
            });
        }
        long sum = 0;
        for (List<Integer> list : charMap.values()) {
            for (int i = 0; i < list.size(); i++) {
                int prev = i == 0 ? -1 : list.get(i-1);
                int next = i == list.size() -  1 ? S.length() : list.get(i+1);
                sum += (list.get(i) - prev) * (next - list.get(i));
            }
        }

        return sum;
    }

    //1+2+3 + 1+2 + 1

    /*
    0123456
    KALAMAN

    012
    135

84
    K
    KA
    KAL
    KALA     -2
    KALAM    -2
    KALAMA   -3
    KALAMAN  -3
56
    A
    AL
    ALA       -2
    ALAM      -2
    ALAMA     -3
    ALAMAN    -3

35
    L
    LA
    LAM
    LAMA      -2
    LAMAN     -2
20
    A
    AM
    AMA       -2
    AMAN      -2
10
    M
    MA
    MAN
4
    A
    AN

    N
     */

    public static void main(String[] args) {
        uniqueLetterString("KALAMAN");
    }
}
