package tasks.leetcode;

import java.util.Stack;
import java.util.StringTokenizer;

public class VerifyPreorderSerializationOfABinaryTree {

    public static boolean isValidSerialization(String preorder) {
        StringTokenizer tokenizer = new StringTokenizer(preorder, ",");
        Stack<String> stack = new Stack<>();
        while (tokenizer.hasMoreTokens()) {
            String next = tokenizer.nextToken();

            if ("#".equals(next) && stack.isEmpty()) return !tokenizer.hasMoreTokens();

            while ("#".equals(next) && "#".equals(stack.peek())) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
                if (stack.isEmpty()) return !tokenizer.hasMoreTokens();
                next = "#";
            }

            stack.push(next);

        }
        return false;
    }

    public static void main(String[] args) {
        //isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        isValidSerialization("#");
    }

}
