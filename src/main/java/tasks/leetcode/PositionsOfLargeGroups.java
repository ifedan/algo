package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        if (S.length() == 0) return result;
        char curr = S.charAt(0);
        int start = 0;
        for (int i = 1; i < S.toCharArray().length; i++) {
            if (S.charAt(i) != curr) {
                curr = S.charAt(i);
                if (i - start >= 3) {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(start);
                    pos.add(i-1);
                    result.add(pos);
                }
                start = i;
            }
        }
        if (S.length() - start >= 3) {
            List<Integer> pos = new ArrayList<>();
            pos.add(start);
            pos.add(S.length()-1);
            result.add(pos);
        }
        return result;
    }
}
