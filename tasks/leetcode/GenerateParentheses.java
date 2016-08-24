package tasks.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        if (n == 0) return Collections.EMPTY_LIST;
        List<String> result = new ArrayList<String>();
        generate(n, n, new StringBuilder(), result);
        return result;
    }

    private static void generate(int open, int close, StringBuilder sb, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }
        if (open > 0) {
            sb.append('(');
            generate(open-1, close, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open < close) {
            sb.append(')');
            generate(open, close-1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
