package tasks.leetcode;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
    public static void main(String[] args) {
        System.out.println(ambiguousCoordinates("(000001)"));
    }

    public static List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1);
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= S.length() - 1; i++) {
            List<String> left = new ArrayList<>();
            String s1 = S.substring(0, i);
            if (isValid(s1)) {
                left.add(s1);
            }
            for (int j = 1; j <= s1.length() - 1; j++) {
                String s3 = s1.substring(0, j);
                String s4 = s1.substring(j);
                String dbl = s3 + "." + s4;
                if (isValid(dbl)) {
                    left.add(dbl);
                }
            }
            List<String> right = new ArrayList<>();
            String s2 = S.substring(i);
            if (isValid(s2)) {
                right.add(s2);
            }
            for (int j = 1; j <= s2.length() - 1; j++) {
                String s3 = s2.substring(0, j);
                String s4 = s2.substring(j);
                String dbl = s3 + "." + s4;
                if (isValid(dbl)) {
                    right.add(dbl);
                }
            }

            for (int m = 0; m < left.size(); m++) {
                for (int n = 0; n < right.size(); n++) {
                    result.add("(" + left.get(m) + ", " + right.get(n) + ")");
                }
            }
        }
        return result;
    }

    private static boolean isValid(String s) {
        if (s.contains(".")) {
            if (s.charAt(s.length() - 1) == '0') return false;
            Double d = Double.parseDouble(s);
            NumberFormat formatter = new DecimalFormat("#0.###############");
            String formatted = formatter.format(d);
            return s.equals(formatted);
        } else {
            return s.equals("0") || s.charAt(0) != '0';
        }
    }
}
