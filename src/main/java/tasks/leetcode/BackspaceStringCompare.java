package tasks.leetcode;

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = toCharStack(S);
        Stack<Character> s2 = toCharStack(T);
        if (s1.size() != s2.size()) return false;
        while (!s1.isEmpty()) {
            if (s1.pop() != s2.pop()) return false;
        }
        return true;
    }

    private static Stack<Character> toCharStack(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#' && !stack.isEmpty()) {
                stack.pop();
            } if (chars[i] != '#') {
                stack.push(chars[i]);
            }
        }
        return stack;
    }
}
