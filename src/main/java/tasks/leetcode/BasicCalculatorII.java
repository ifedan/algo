package tasks.leetcode;

public class BasicCalculatorII {

    public static int calculate(String s) {
        s = s.replaceAll(" ", "");

        int result = 0;
        long prev = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            long curr = 0;
            if (Character.isDigit(s.charAt(i))) {
                curr = Character.getNumericValue(s.charAt(i));
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    curr *= 10;
                    curr += Character.getNumericValue(s.charAt(i+1));
                    i++;
                }
            }
            if (sign == '+') {
                result += prev;
                prev = curr;
            } else if (sign == '-') {
                result += prev;
                prev = -curr;
            } else if (sign == '*') {
                prev *= curr;
            } else if (sign == '/') {
                prev /= curr;
            }

            if (i < s.length()) {
                sign = s.charAt(i);
            }
        }
        result += prev;
        return result;
    }

}
