package tasks.leetcode;

public class StrobogrammaticNumber {
    public static void main(String[] args) {

    }

    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        while (i < j) {
            if ((num.charAt(i) != '0' && num.charAt(i) != '1' && num.charAt(i) != '8' && num.charAt(i) != '6' && num.charAt(i) != '9') ||
                    (num.charAt(i) == '6' && num.charAt(j) != '9') ||
                    (num.charAt(i) == '9' && num.charAt(j) != '6') ||
                    (num.charAt(i) == '0' && num.charAt(j) != '0') ||
                    (num.charAt(i) == '1' && num.charAt(j) != '1') ||
                    (num.charAt(i) == '8' && num.charAt(j) != '8')) {
                return false;
            }
            i++;
            j--;
        }
        if (i == j) {
            return num.charAt(i) == '8' || num.charAt(i) == '0' || num.charAt(i) == '1';
        }
        return true;
    }
}
