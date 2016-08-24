package tasks.leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int i = 0;
        for (i = 0; i < heights.length;) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int area;
                if (stack.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - stack.peek() - 1);
                }
                max = Math.max(max, area);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area;
            if (stack.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - stack.peek() - 1);
            }
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2, 0, 2});
    }

}
