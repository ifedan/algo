package tasks.misc;

import java.util.Stack;

public class MaxSizeRectangleInMatrix {

    public static int solve(boolean[][] matrix) {
        int[] hist = new int[matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!matrix[i][j]) {
                    hist[j] = 0;
                } else {
                    hist[j]++;
                }
            }
            max = Math.max(max, maxHist(hist));
        }
        return max;
    }

    private static int maxHist(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = Integer.MIN_VALUE;
        while (i < a.length) {
            if (stack.isEmpty() || stack.peek() < a[i]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, a[i]*top);
                } else {
                    max = Math.max(max, a[i]*(top-stack.peek()-1));
                }
            }
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                max = Math.max(max, a[i]*top);
            } else {
                max = Math.max(max, a[i]*(top-stack.peek()-1));
            }
        }
        return max;
    }

}
