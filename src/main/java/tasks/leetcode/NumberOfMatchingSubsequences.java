package tasks.leetcode;

import java.util.*;

public class NumberOfMatchingSubsequences {
    static class WordWithPos {
        char[] word;
        int pos;
        WordWithPos(String w) {
            this.word = w.toCharArray();
            this.pos = 0;
        }
    }

    public static int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<WordWithPos>> waitingList = new HashMap<>();
        int total = 0;

        for (String word : words) {
            waitingList.compute(word.charAt(0), (k, v) -> {
                if (v == null) v = new ArrayList<>();
                v.add(new WordWithPos(word));
                return v;
            });
        }

        for (char c : S.toCharArray()) {
            List<WordWithPos> list = waitingList.remove(c);
            if (list == null) continue;
            for (WordWithPos wwp : list) {
                wwp.pos = wwp.pos + 1;
                if (wwp.pos == wwp.word.length) {
                    total++;
                } else {
                    waitingList.compute(wwp.word[wwp.pos], (k, v) -> {
                        if (v == null) v = new ArrayList<>();
                        v.add(wwp);
                        return v;
                    });
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"});
    }
}
