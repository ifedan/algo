package tasks.leetcode;

import java.util.Stack;

public class BasicCalculator {

    public static int calc(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = Character.getNumericValue(s.charAt(i));
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num *= 10;
                    num += Character.getNumericValue(s.charAt(i+1));
                    i++;
                }
                result += num * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}
