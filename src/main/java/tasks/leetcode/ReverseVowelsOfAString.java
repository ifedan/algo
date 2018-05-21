package tasks.leetcode;

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        if (s == null) return null;
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (i < j && !isVowel(arr[i])) i++;
            while (i < j && !isVowel(arr[j])) j--;
            if (i < j) {
                char t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }
        return new String(arr);
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u';
    }

}
