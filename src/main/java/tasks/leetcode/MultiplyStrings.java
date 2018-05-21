package tasks.leetcode;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        String tens = "";
        String sum = "0";
        for (int i = num2.length() - 1; i>= 0; i--) {
            char c = num2.charAt(i);
            String res = multiply(num1, Character.getNumericValue(c));
            res = res + tens;
            tens = tens + "0";
            sum = sum(sum, res);
        }
        return sum;
    }

    public static String multiply(String num1, int num2) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int extra = 0;
        while (i <= num1.length()) {
            int x = Character.getNumericValue(num1.charAt(num1.length() - i));

            int val = x * num2;
            if (extra > 0) {
                val += extra;
                extra = 0;
            }
            if (val >=10) {
                extra = val / 10;
                val = val % 10;
            }
            sb.insert(0, val);
            i++;
        }
        if (extra>0) {
            sb.insert(0, extra);
        }
        return sb.toString();
    }

    public static String sum(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        boolean extra = false;
        while (i <= num1.length() || i <= num2.length()) {
            int x = 0;
            if (i <= num1.length()) {
                x = Character.getNumericValue(num1.charAt(num1.length() - i));
            }

            int y = 0;
            if (i <= num2.length()) {
                y = Character.getNumericValue(num2.charAt(num2.length() - i));
            }

            int sum = x + y;
            if (extra) {
                sum += 1;
                extra = false;
            }
            if (sum >=10) {
                extra = true;
                sum -= 10;
            }
            sb.insert(0, sum);
            i++;
        }
        if (extra) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

}
