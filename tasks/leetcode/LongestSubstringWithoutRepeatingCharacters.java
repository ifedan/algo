package tasks.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<Character>();
        Set<Character> set = new HashSet<Character>();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                queue.add(s.charAt(i));
                sum++;
            } else {
                max = Math.max(max, sum);
                Character c;
                do {
                    c = queue.poll();
                    set.remove(c);
                    sum--;
                } while (c != s.charAt(i));
                queue.add(s.charAt(i));
                set.add(s.charAt(i));
                sum++;
            }
        }
        return max;
    }

}
