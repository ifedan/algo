package tasks.misc;

import java.util.Stack;

public class MaxRectInHistogram {

    public static int solve(int[] hist) {

        int i = 0;
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        while (i < hist.length) {
            if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                int area;
                if (stack.isEmpty()) {
                    area = hist[top] * i;
                } else {
                    area = hist[top] * (i - stack.peek() - 1);
                }
                max = Math.max(max, area);
            }
            i++;
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            int area;
            if (stack.isEmpty()) {
                area = hist[top] * i;
            } else {
                area = hist[top] * (i - stack.peek() - 1);
            }
            max = Math.max(max, area);
        }
        return max;
    }



}
