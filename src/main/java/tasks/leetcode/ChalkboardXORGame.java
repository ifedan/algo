package tasks.leetcode;

import java.util.*;

public class ChalkboardXORGame {

    public boolean xorGameCorrect(int[] nums) {
        int xor = 0;
        for (int i: nums) xor ^= i;
        return xor == 0 || nums.length % 2 == 0;
    }

    public boolean xorGame(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
            counter.merge(nums[i], 1, (v, acc) -> v + acc);
        }
        if (xor == 0) return true;
        int oddCount = 0;
        for (Integer cnt : counter.values()) {
            if (cnt % 2 != 0) oddCount++;
        }
        return play(counter, oddCount, true);
    }

    private static boolean play(Map<Integer, Integer> map, int oddCount, boolean alise) {
        if (oddCount == 0) {
            return alise;
        }
        int count = 0;
        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = it.next();
            Integer value = entry.getValue();
            if (value == 0) {
                continue;
            }
            count += value;
            boolean odd = value % 2 != 0;
            if (odd && oddCount == 1) {
                continue;
            }
            entry.setValue(value - 1);
            boolean win = play(map, odd ? oddCount-1 : oddCount + 1, !alise);
            if (win) {
                return win;
            }
            entry.setValue(value);
        }
        if (count == 0) {
            return alise;
        }
        if (count == 1) {
            return !alise;
        }
        return false;
    }


}
