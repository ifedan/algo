package tasks.leetcode;

import java.util.Arrays;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);

        int i = 25;
        while (i >= 0 && map[i] == map[25]) i--;

        /*
        CAAAABBBB - 2

        A _ _ A _ _ A _ _     A_ _
        <-(n+1)*max(c[25])->   <-count of numbers of chars with same count as max(c[25]) = 25-i)
         */

        return Math.max(tasks.length, (map[25]-1) * (n+1) + 25 - i);
    }

    public static void main(String[] args) {
        leastInterval("ACCCEEE".toCharArray(), 2);
    }

}
