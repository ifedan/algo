package tasks.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class UglyNumberII {

    public static int uglyNumberII(int n) {
        if (n == 1) return 1;
        Queue<Integer> two = new PriorityQueue<>();
        Queue<Integer> three = new PriorityQueue<>();
        Queue<Integer> five = new PriorityQueue<>();
        addToQueues(1, two, three, five);

        int twoVal = two.peek() * 2;
        int threeVal = three.peek() * 3;
        int fiveVal = five.peek() * 5;
        int k = 1;
        int val = 0;
        while (k < n) {
            int min = Math.min(twoVal, Math.min(threeVal, fiveVal));

            if (twoVal == min) two.poll();
            if (threeVal == min) three.poll();
            if (fiveVal == min) five.poll();

            addToQueues(min, two, three, five);
            val = min;
            twoVal = two.peek() * 2;
            threeVal = three.peek() * 3;
            fiveVal = five.peek() * 5;
            k++;
        }
        return val;
    }

    private static void addToQueues(int v, Queue<Integer> two, Queue<Integer> three, Queue<Integer> five) {
        two.offer(v);
        three.offer(v);
        five.offer(v);
    }

}
