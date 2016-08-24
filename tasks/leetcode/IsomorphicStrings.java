package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 0) return true;
        Map<Character, Character> a2b = new HashMap<>();
        Map<Character, Character> b2a = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (a2b.containsKey(c1) && c2 != a2b.get(c1)) return false;
            if (b2a.containsKey(c2) && c1 != b2a.get(c2)) return false;

            a2b.put(c1, c2);
            b2a.put(c2, c1);
        }
        return true;
    }

}
