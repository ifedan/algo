package tasks.leetcode;

public class AdditiveNumber {

    public static boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() - 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break;
            String s1 = num.substring(0, i);
            for (int j = i+1; j <=num.length() -1; j++) {
                if (num.charAt(i) == '0' && j > i+1) break;
                String s2 = num.substring(i, j);
                if (isValid(num, j, Long.parseLong(s1), Long.parseLong(s2))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(String s, int start, long a, long b) {
        if (start == s.length()) return true;
        String sum = Long.toString(a+b);
        if (s.indexOf(sum, start) != start) return false;
        else return isValid(s, start+sum.length(), b, a+b);
    }

}
