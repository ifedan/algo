package tasks.leetcode;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] as = s.toCharArray();
        char[] at = t.toCharArray();
        Arrays.sort(as);
        Arrays.sort(at);
        for (int i = 0; i < as.length; i++) {
            if (as[i] != at[i]) return false;
        }
        return true;
    }

}
