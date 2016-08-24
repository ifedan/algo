package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), 1, (a, b) -> a+b);
        }

        int count = 0;
        int minLen = s.length()+1;
        int minLeft = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++){
            char cRight = s.charAt(r);
            if (map.containsKey(cRight)) {
                map.computeIfPresent(cRight, (k,v)->v-1);
                if(map.get(cRight) >= 0) {
                    count++;
                }
            }
            while (count == t.length()) {
                if (minLen > (r-l+1)) {
                    minLen = (r-l+1);
                    minLeft = l;
                }
                char cLeft = s.charAt(l);
                if (map.containsKey(cLeft)) {
                    map.computeIfPresent(cLeft, (k,v)->v+1);
                    if(map.get(cLeft) > 0) {
                        count--;
                    }
                }
                l++;
            }
        }

        if(minLen>s.length())
        {
            return "";
        }

        return s.substring(minLeft,minLeft+minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("abc", "ab"));
    }
}
