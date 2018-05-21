package tasks.leetcode;

import java.util.StringTokenizer;

public class GoatLatin {
    public static String toGoatLatin(String S) {
        StringTokenizer st = new StringTokenizer(S, " ");
        StringBuilder result = new StringBuilder();
        StringBuilder post = new StringBuilder("a");
        while (st.hasMoreElements()) {
            transform(st.nextToken(), result, post);
        }
        return result.deleteCharAt(0).toString();
    }

    private static void transform(String str, StringBuilder result, StringBuilder post) {
        if ("aeiou".indexOf(Character.toLowerCase(str.charAt(0))) >= 0) {
            result.append(" ").append(str).append("ma").append(post);
        } else {
            result.append(" ").append(str.substring(1)).append(str.charAt(0)).append("ma").append(post);
        }
        post.append("a");
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }
}
