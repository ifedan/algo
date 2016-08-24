package tasks.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            int val;
            if ("+".equals(tokens[i])) {
                int a = stack.pop();
                int b = stack.pop();
                val = a + b;
            } else if ("-".equals(tokens[i])) {
                int a = stack.pop();
                int b = stack.pop();
                val = b - a;
            } else if ("*".equals(tokens[i])) {
                int a = stack.pop();
                int b = stack.pop();
                val = a * b;
            } else if ("/".equals(tokens[i])) {
                int a = stack.pop();
                int b = stack.pop();
                val = b / a;
            } else {
                val = Integer.parseInt(tokens[i]);
            }
            stack.push(val);
        }
        return stack.pop();
    }
}
