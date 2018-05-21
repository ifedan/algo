package tasks.leetcode;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

    public static Collection<String> letterCombinations(String digits) {
        Map<Character, List<Character>> phone = new HashMap<Character, List<Character>>();
        phone.put('0', new ArrayList<Character>());
        phone.get('0').add(' ');
        phone.put('1', new ArrayList<Character>());
        phone.put('2', Arrays.asList('a', 'b', 'c'));
        phone.put('3', Arrays.asList('d', 'e', 'f'));
        phone.put('4', Arrays.asList('g', 'h', 'i'));
        phone.put('5', Arrays.asList('j', 'k', 'l'));
        phone.put('6', Arrays.asList('m', 'n', 'o'));
        phone.put('7', Arrays.asList('p', 'q', 'r', 's'));
        phone.put('8', Arrays.asList('t', 'u', 'v'));
        phone.put('9', Arrays.asList('w', 'x', 'y', 'z'));


        Queue<String> result = new LinkedList<String>();
        char first = digits.charAt(0);
        if (first == '1') {
            result.offer("");
        } else {
            for (char c : phone.get(first)) {
                result.offer("" + c);
            }
        }

        int i = 1;
        while (i < digits.length()) {
            char num = digits.charAt(i);
            if (num == '1') {
                i++;
                continue;
            }
            int size = result.size();
            for (int j = 0; j < size; j++) {
                String s = result.poll();
                for (char c : phone.get(num)) {
                    result.offer(s + c);
                }
            }
            i++;
        }

        return result;
    }

}
