package tasks.leetcode;

import java.util.Arrays;

public class ShortEncodingOfWords {
    public static int minimumLengthEncoding(String[] words) {
        if (words.length == 1) return words[0].length() + 1;
        words = Arrays.stream(words).map(w -> new StringBuilder(w).reverse().toString()).sorted().toArray(String[]::new);
        int total = 0;
        for (int i = words.length-1; i >= 0;) {
            total += words[i].length() + 1;
            i--;
            while (i >=0 && words[i+1].contains(words[i])) i--;
        }
        return total;
    }
}
