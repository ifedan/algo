package tasks.leetcode;

import java.util.*;

public class PalindromePairs {

    public static void main(String[] args) {
        palindromePairs(new String[]{"bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"});
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordToIndex = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordToIndex.put(words[i], i);
        }
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            char[] reversed = new StringBuffer(words[i]).reverse().toString().toCharArray();
            set.addAll(findPalindromes(i, words[i], reversed, true, wordToIndex));
            set.addAll(findPalindromes(i, words[i], reversed, false, wordToIndex));
        }
        List<List<Integer>> result = new ArrayList<>();
        for (long pair : set) {
            List<Integer> list = new ArrayList<>();
            list.add((int)(pair >> 32));
            list.add((int)(pair));
            result.add(list);
        }

        Integer index = wordToIndex.get("");
        if (index != null) {
            for (int i = 0; i < words.length; i++) {
                if (index == i) continue;
                if (isPalindrome(words[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(index);
                    list.add(i);
                    result.add(list);

                    list = new ArrayList<>();
                    list.add(i);
                    list.add(index);
                    result.add(list);
                }
            }
        }

        return result;
    }

    private static Set<Long> findPalindromes(int index, String str, char[] reversedStr, boolean prefix, Map<String, Integer> wordToIndex) {
        Set<Long> result = new HashSet<>();
        int i = 0;
        boolean isPalindrome;
        do {
            String toAdd = prefix ?
                    new String(reversedStr, 0, reversedStr.length - i) :
                    new String(reversedStr, i, reversedStr.length - i);
            String toCheck = prefix ?
                    toAdd + str :
                    str + toAdd;
            isPalindrome = isPalindrome(toCheck);
            Integer otherStrIndex = wordToIndex.get(toAdd);
            if (isPalindrome && otherStrIndex != null && otherStrIndex != index) {
                int start = prefix ? otherStrIndex : index;
                int end = prefix ? index : otherStrIndex;
                result.add((((long)start) << 32) | end);
            }
            i++;
        } while (i < str.length());
        return result;
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
