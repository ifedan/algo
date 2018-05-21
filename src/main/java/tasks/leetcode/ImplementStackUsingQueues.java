package tasks.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    class MyStack {
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> temp = new LinkedList<Integer>();

        // Push element x onto stack.
        public void push(int x) {
            if (queue.isEmpty()) queue.offer(x);
            else {
                while (!queue.isEmpty()) temp.offer(queue.poll());
                queue.offer(x);
                while (!temp.isEmpty()) queue.offer(temp.poll());
            }
        }

        // Removes the element on top of the stack.
        public void pop() {
            queue.poll();
        }

        // Get the top element.
        public int top() {
            return queue.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
