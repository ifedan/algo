package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        char[] m = new char[2*s.length() + 3];
        int k = 0;
        for (int i = 1; i < m.length-1; i++) {
            if (i % 2 == 0) m[i] = s.charAt(k++);
            else m[i] = '#';
        }
        m[0] = '@';
        m[m.length-1] = '$';

        int right = 0;
        int center = 0;
        int[] t = new int[m.length];

        for (int i = 1; i < t.length-1; i++) {
            int mirror = center - (i - center);
            if (right > i) {
                t[i] = Math.min(t[mirror], right - i);
            }

            while (m[i + (t[i]+1)] == m[i - (t[i]+1)]) {
                t[i]++;
            }

            if (right < t[i] + i) {
                center = i;
                right = t[i] + i;
            }
        }

        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] > max) {
                max = t[i];
                index = i;
            }
        }

        int i = index;
        int j = index;
        List<Character> queue = new ArrayList<>();
        boolean even = (m[index] == '#');
        while (i >= 0 && j < m.length && m[i] == m[j]) {
            if (m[i] != '#' && m[i] != '@' && m[i] != '$') {
                queue.add(m[i]);
            }
            i--;
            j++;
        }
        StringBuilder sb = new StringBuilder();
        for (int p = queue.size() - 1; p>= 0; p--) {
            sb.append(queue.get(p));
        }
        if (!even) {
            queue.remove(0);
        }
        for (int p = 0; p < queue.size(); p++) {
            sb.append(queue.get(p));
        }

        return sb.toString();
    }

}
