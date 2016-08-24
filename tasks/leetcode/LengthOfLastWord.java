package tasks.leetcode;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int i = s.length()-1;
        while (i>=0 && s.charAt(i) == ' ') {
            i--;
        }

        int size = 0;
        while (i>=0 && s.charAt(i) != ' ') {
            i--;
            size++;
        }
        return size;
    }
}
