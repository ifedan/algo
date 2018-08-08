package tasks.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int j = 0;

        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            //remove all indexes from beginning if head of deque is out of range k
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            //remove all indexes from tail whos values less then current one
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k-1) {
                res[j++] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

}
