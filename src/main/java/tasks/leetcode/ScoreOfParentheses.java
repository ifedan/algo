package tasks.leetcode;

import java.util.Stack;

public class ScoreOfParentheses {
    public static int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push("(");
            } else if (c == ')') {
                String str;
                int sum = 0;
                do {
                    str = stack.pop();
                    if (!"(".equals(str)) {
                        sum += Integer.parseInt(str);
                    }
                } while (!"(".equals(str));
                if (sum == 0) {
                    stack.push("1");
                } else {
                    stack.push(Integer.toString(2*sum));
                }
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += Integer.parseInt(stack.pop());
        }
        return sum;
    }

    public static void main(String[] args) {
        //System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("()()"));
        //System.out.println(scoreOfParentheses("(())"));
        //System.out.println(scoreOfParentheses("(()(()))"));
    }
}
