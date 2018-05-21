package tasks.leetcode;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        char[] str = removeSpaces(s).toCharArray();
        reverse(str, 0, str.length-1);
        int j = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ' && j == -1) {
                j = i;
            }
            if (str[i] == ' ' && j != -1) {
                reverse(str, j, i-1);
                j = -1;
            }
        }
        if (j != -1) {
            reverse(str, j, str.length-1);
        }
        return new String(str, 0, str.length);
    }

    public static void reverse(char[] str, int s, int e) {
        while (s <= e) {
            char temp = str[s];
            str[s] = str[e];
            str[e] = temp;
            s++;
            e--;
        }
    }

    public static String removeSpaces(String s) {
        char[] str = new char[s.length()];
        int j = 0;
        for (int i = 0; i < str.length; i++) {
            if (s.charAt(i) == ' ' && (j == 0 || str[j-1] == ' ')) continue;
            str[j++] = s.charAt(i);
        }
        while (j > 0 && str[j-1] == ' ') j--;
        return new String(str, 0, j);
    }

}
