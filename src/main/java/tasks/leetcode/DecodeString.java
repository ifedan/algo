package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
    static interface Expression {
        void append(StringBuffer sb);
    }

    static class BracketExpression implements Expression {
        List<Expression> children = new ArrayList<>();
        int repeat;

        BracketExpression(int rep) {
            this.repeat = rep;
        }

        public void append(StringBuffer sb) {
            for (int i = 0; i < repeat; i++) {
                for (Expression e : children) {
                    e.append(sb);
                }
            }
        }

        public void addChild(Expression expr) {
            children.add(expr);
        }

    }
    static class CharExpression implements Expression {
        char c;
        CharExpression(char c) {
            this.c = c;
        }
        public void append(StringBuffer sb) {
            sb.append(c);
        }
    }


    public static String decodeString(String s) {
        Stack<BracketExpression> stack = new Stack<>();
        BracketExpression root = new BracketExpression(1);
        stack.push(root);
        int repeat = 0;
        for (char c : s.toCharArray()) {
            BracketExpression parent = stack.peek();
            if (Character.isDigit(c)) {
                repeat = repeat * 10;
                repeat = repeat + Character.getNumericValue(c);
            } else if (c == '[') {
                BracketExpression child = new BracketExpression(repeat);
                repeat = 0;
                parent.addChild(child);
                stack.push(child);
            } else if (c == ']') {
                stack.pop();
            } else {
                parent.addChild(new CharExpression(c));
            }
        }
        StringBuffer sb = new StringBuffer();
        root.append(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        decodeString("2[abc]3[cd]ef");
    }
}
