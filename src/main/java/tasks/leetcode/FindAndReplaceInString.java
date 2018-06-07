package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {
    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, String[]> fixed = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            char[] src = sources[i].toCharArray();
            boolean same = true;
            for (int c = 0; c < src.length; c++) {
                if (src[c] != S.charAt(indexes[i] + c)) {
                    same = false;
                    break;
                }
            }
            if (same) {
                fixed.put(indexes[i], new String[]{sources[i], targets[i]});
            }
        }
        if (fixed.size() == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < S.toCharArray().length; ) {
            String[] pair = fixed.get(c);
            if (pair != null) {
                sb.append(pair[1]);
                c += pair[0].length();
            } else {
                sb.append(S.charAt(c));
                c++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String result = findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"});
        System.out.println(result);
    }
}
