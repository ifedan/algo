package tasks.leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack =new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((top == '{' && c != '}') || (top == '(' && c != ')') || (top == '[' && c != ']')) return false;
            }
        }
        return stack.isEmpty();
    }

}
