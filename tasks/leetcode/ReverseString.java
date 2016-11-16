package tasks.leetcode;

public class ReverseString {
    public static String reverseString(String s) {
        if (s == null) return null;
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        return new String(arr);
    }
}
