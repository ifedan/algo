package tasks.leetcode;

import java.util.TreeSet;

public class CardFlippingGame {
    public static int flipgame(int[] fronts, int[] backs) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < fronts.length; i++) {
            set.add(fronts[i]);
            set.add(backs[i]);
        }
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.remove(fronts[i]);
            }
        }
        return set.isEmpty() ? 0 : set.first();
    }
}
