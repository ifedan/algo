package tasks.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    public static class MedianFinder {

        PriorityQueue<Integer> small = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        PriorityQueue<Integer> large = new PriorityQueue<Integer>();

        // Adds a number into the data structure.
        public void addNum(int num) {
            if (small.isEmpty() && large.isEmpty()) {
                small.offer(num);
                return;
            }
            if (small.isEmpty() || large.isEmpty()) {
                int val = small.isEmpty() ? large.poll() : small.poll();
                if (val < num) {
                    small.offer(val);
                    large.offer(num);
                } else {
                    small.offer(num);
                    large.offer(val);
                }
                return;
            }
            if (num < large.peek()) {
                small.offer(num);
            } else {
                large.offer(num);
            }
            while (large.size() - small.size() >= 2) small.offer(large.poll());
            while (small.size() - large.size() >= 2) large.offer(small.poll());
        }

        // Returns the median of current data stream
        public double findMedian() {
            if (small.size() > large.size()) {
                return small.peek();
            } else if (small.size() < large.size()) {
                return large.peek();
            } else {
                return ((double)(small.peek() + large.peek())) / 2;
            }
        }
    };


}
