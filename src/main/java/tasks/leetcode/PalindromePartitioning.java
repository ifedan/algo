package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result  = new ArrayList<>();
        partition(s, 0, 0, new ArrayList<>(), result);
        return result;
    }


    public static void partition(String s, int start, int size, List<String> output, List<List<String>> result) {
        if (size == s.length()) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int len = 1; len <= s.length()-start; len++) {
            int end = start+len-1;
            if (isPalindrome(s, start, end)) {
                output.add(new String(s.toCharArray(), start, len));
                partition(s, end+1, size + len, output, result);
                output.remove(output.size() - 1);
            }
        }

    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aa"));
    }


}
