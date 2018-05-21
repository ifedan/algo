package tasks.leetcode;

public class ImplementStrStr {

    public static void main(String[] args) {
        strStr("mississippi","issip");
    }

    public static int strStr(String haystack, String needle) {
        int t[] = getPrefixMatrix(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = t[j-1];
                } else {
                    i++;
                }
            }
        }
        if (j != needle.length()) {
            return -1;
        }
        return i - needle.length();

    }

    private static int[] getPrefixMatrix(String prefix) {
        int t[] = new int[prefix.length()];
        int i = 1;
        int j = 0;
        while (i < prefix.length()) {
            if (prefix.charAt(i) == prefix.charAt(j)) {
                t[i] = j + 1;
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = t[j-1];
                } else {
                    t[i] = 0;
                    i++;
                }
            }
        }
        return t;
    }

}
