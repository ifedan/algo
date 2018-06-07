package tasks.leetcode;

import java.util.*;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String s : banned) {
            bannedSet.add(s);
        }
        StringTokenizer st = new StringTokenizer(paragraph);
        String result = null;
        int maxCount = 0;
        Map<String, Integer> map = new HashMap<>();
        while (st.hasMoreTokens()) {
            String word = st.nextToken().replaceAll("[^a-zA-Z]+","").toLowerCase();
            if (!bannedSet.contains(word)) {
                int count = map.merge(word, 1, (v, acc) -> v + acc);
                if (count > maxCount) {
                    result = word;
                    maxCount = count;
                }
            }
        }
        return result;
    }
}
