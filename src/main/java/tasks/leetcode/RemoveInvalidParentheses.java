package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

    public static List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<String>();
        remove(s, 0, 0, new char[]{'(', ')'}, result);
        return new ArrayList<String>(result);
    }

    private static void remove(String s, int x, int y, char[] p, Set<String> result) {
        boolean valid = true;
        for (int stack = 0, i = x; i < s.length(); i++) {
            if (s.charAt(i) == p[0]) stack++;
            if (s.charAt(i) == p[1]) stack--;
            if (stack < 0) {
                valid = false;
                for (int j = y; j <= i; j++) {
                    if (s.charAt(j) == p[1]) {
                        remove(s.substring(0, j) + s.substring(j+1, s.length()), i, j, p, result);
                    }
                }
                break;
            }
        }
        if (valid) {
            String reversed = new StringBuilder(s).reverse().toString();
            if (p[0] == '(') {// finished left to right
                remove(reversed, 0, 0, new char[]{')', '('}, result);
            } else {
                result.add(reversed);
            }
        }
    }

}
