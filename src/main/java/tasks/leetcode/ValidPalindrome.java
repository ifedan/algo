package tasks.leetcode;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        int i = 0;
        int j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
