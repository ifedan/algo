package tasks.leetcode;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int[] area = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    area[j] = 0;
                } else {
                    area[j] += 1;
                }
            }
            max = Math.max(max, maxHistogram(area));
        }
        return max;
    }

    private static int maxHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max= Integer.MIN_VALUE;

        for (i = 0; i < heights.length; ) {
            if (stack.isEmpty() || heights[stack.peek()] < heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int area = 0;
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
            int area = 0;
            if (stack.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - stack.peek() - 1);
            }
            max = Math.max(max, area);
        }
        return max;
    }



}
