package tasks.leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    public static int max(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
                else stack.push(i);
            }
        }
        if (stack.isEmpty()) return s.length();

        int max = Integer.MIN_VALUE;

        int len = s.length();
        int indexOfIncorrectParenthes = 0;
        while (!stack.isEmpty()) {
            indexOfIncorrectParenthes = stack.pop();
            max = Math.max(max, len-indexOfIncorrectParenthes-1);
            len = indexOfIncorrectParenthes;
        }
        max = Math.max(max, len);
        return max;
    }


}
