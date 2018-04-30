package leetcode;

import java.util.TreeMap;

public class FriendsOfAppropriateAges {
    public static int numFriendRequests(int[] ages) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < ages.length; i++) {
            tree.compute(ages[i], (k, v) -> {
               if (v == null) v = 0;
               return v + 1;
            });
        }
        int count = 0;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] <= 14) continue;
            else {
                int lower = (int)(0.5*ages[i] + 7);
                int sum = tree.subMap(lower, false, ages[i], true).values().stream().mapToInt(Integer::intValue).sum();
                count += (sum -1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        numFriendRequests(new int[]{73,106,39,6,26,15,30,100,71,35,46,112,6,60,110});
    }
}
