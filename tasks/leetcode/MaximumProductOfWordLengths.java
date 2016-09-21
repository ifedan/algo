package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        List<Word> list = new ArrayList<Word>();
        for (String s : words) {
            list.add(new Word(s));
        }

        int max = 0;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if ((list.get(i).mask & list.get(j).mask) == 0) {
                    max = Math.max(max, list.get(i).size * list.get(j).size);
                }

            }
        }
        return max;
    }

    private class Word {
        int mask;
        int size;

        Word(String s) {
            for (char c : s.toCharArray()) {
                mask |= (1 <<(c-'a'));
            }
            this.size = s.length();
        }
    }

}
