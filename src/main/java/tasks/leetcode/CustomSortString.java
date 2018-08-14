package tasks.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public static void main(String[] args) {
        customSortString("cba", "abcd");
    }
    public static String customSortString(String S, String T) {
        Map<Character, Integer> char2pos = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char2pos.put(S.charAt(i), i);
        }
        for (int i = 0; i < T.length(); i++) {
            if (!char2pos.containsKey(T.charAt(i))) {
                char2pos.put(T.charAt(i), S.length() + i);
            }
        }
        Character[] t = new Character[T.length()];
        for (int i = 0; i < T.length(); i++) {
            t[i] = T.charAt(i);
        }
        Arrays.sort(t, (a, b) -> char2pos.get(a) - char2pos.get(b));
        char[] result = new char[t.length];
        for (int i = 0; i < t.length; i++) {
            result[i] = t[i];
        }
        return new String(result);
    }
}
