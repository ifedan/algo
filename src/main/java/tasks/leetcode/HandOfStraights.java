package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.merge(hand[i], 1, (v, acc) -> v + acc);
        }
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> pivot = map.entrySet().iterator().next();
            int index = pivot.getKey();
            while (map.containsKey(index-1)) {
                index--;
            }
            for (int i = 0; i < W; i++) {
                if (!map.containsKey(index + i)) {
                    return false;
                }
                map.computeIfPresent(index+ i, (k, v) -> {
                    if (v == 1) return null;
                    else return v-1;
                });
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = isNStraightHand(new int[]{1,1,2,2,3,3}, 2);
        System.out.println(res);
    }
}
