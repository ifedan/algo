package tasks.leetcode;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (prefix.equals(strs[i])) continue;
            int k = 0;
            while (k < prefix.length() && k < strs[i].length()
                    && prefix.charAt(k) == strs[i].charAt(k)) {
                k++;
            }
            prefix = prefix.substring(0, k);
        }
        return prefix;

    }

}
