package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static boolean wordPattern(String pattern, String str) {
        java.util.StringTokenizer st = new java.util.StringTokenizer(str);
        Map<Character, String> char2Word = new HashMap<Character, String>();
        Map<String, Character> word2Char = new HashMap<String, Character>();
        int i = 0;
        while (st.hasMoreTokens() && i < pattern.length()) {
            Character c = pattern.charAt(i);
            String w = st.nextToken();
            String wordCorr = char2Word.get(c);
            Character charCorr = word2Char.get(w);

            if (wordCorr == null && charCorr == null) {
                word2Char.put(w,  c);
                char2Word.put(c, w);
            } else if (!w.equals(wordCorr) || !c.equals(charCorr)){
                return false;
            }
            i++;
        }
        return !st.hasMoreTokens() && i == pattern.length();
    }

}
