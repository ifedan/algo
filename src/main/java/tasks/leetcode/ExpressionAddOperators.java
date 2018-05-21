package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        calc(num, target, 0, new ArrayList<>(), 0, 0, result);
        return result;
    }

    public static void calc(String s, int sum, int start, List<String> output, long val, long prev, List<String> result) {
        if (start == s.length()) {
            System.out.println(output + " = " + val);
            if (val == sum) {
                result.add(print(output));
            }
            return;
        }

        int maxLen = s.charAt(start) == '0' ? 1 : s.length() - start;
        for(int len = 1; len <= maxLen; len++) {
            long i = Long.valueOf(s.substring(start, start+len));

            output.add((start == 0 ? "" : "+") +i);
            calc(s, sum, start+len, output, val + i, i, result);
            output.remove(output.size()-1);

            if (start != 0) {

                //if (s.charAt(start) != '0') {
                    output.add("-" + i);
                    calc(s, sum, start + len, output, val - i, -i, result);
                    output.remove(output.size() - 1);
                //}

                output.add("*" + i);
                calc(s, sum, start + len, output, val - prev + prev * i, prev * i, result);
                output.remove(output.size() - 1);
            }
        }
    }

    private static String print(List<String> out) {
        StringBuilder sb = new StringBuilder();
        for (String s : out) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addOperators("000", 6));
    }

}
