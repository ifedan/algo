package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {

    public static int expressiveWords(String S, String[] words) {
        List<MaskChar> mask = mask(S);
        int result = 0;
        for (String word : words) {
            if (testWord(word, mask)) result++;
        }
        return result;
    }

    private static List<MaskChar> mask(String s) {
        List<MaskChar> mask = new ArrayList<>();
        int i = -1;
        do {
            i++;
            char c = s.charAt(i);
            int len = 1;
            while (i < s.length()-1 && c == s.charAt(i+1)) {
                i++;
                len++;
            }
            mask.add(new MaskChar(c, len));
        } while (i < s.length() - 1);
        return mask;
    }

    private static boolean testWord(String word, List<MaskChar> mask) {
        int i = -1;
        int maskIndex = 0;
        do {
            i++;
            char c = word.charAt(i);
            MaskChar maskChar = mask.get(maskIndex++);
            if (maskChar.c != c) return false;

            int len = 1;
            while (i < word.length()-1 && c == word.charAt(i+1)) {
                i++;
                len++;
            }

            if (maskChar.len < 3 && len != maskChar.len) return false;
            if (maskChar.len >= 3 && len > maskChar.len) return false;
        } while (i < word.length() - 1);
        return maskIndex == mask.size();
    }

    static class MaskChar {
        char c;
        int len;
        MaskChar(char c, int len) {
            this.c = c;
            this.len = len;
        }
    }

    public static void main(String[] args) {
        expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
    }
}
