package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
    	if (s == null || s.length() <= 1) return s;
    	
    	Map<Character, Integer> charTolastPos = new HashMap<Character, Integer>();
    	Map<Integer, Character> lastPosToChar = new TreeMap<Integer, Character>();
        for (int i = 0; i < s.length(); i++) {
        	charTolastPos.put(s.charAt(i), i);
        }
        for (Map.Entry<Character, Integer> entry : charTolastPos.entrySet()) {
        	lastPosToChar.put(entry.getValue(), entry.getKey());
        }
        
        int size = charTolastPos.size();

        int start = 0;
        int end = lastPosToChar.keySet().iterator().next();
        
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < size; k++) {
           char min = 'z' + 1;
           for (int i = start; i <= end; i++) {
              if (charTolastPos.containsKey(s.charAt(i)) && s.charAt(i) < min) {
            	  min = s.charAt(i);
            	  start = i + 1;
              }
           }
           sb.append(min);
           
           lastPosToChar.remove(charTolastPos.remove(min));
           
           if (end == s.length()-1 || lastPosToChar.isEmpty()) break;
           
           if (s.charAt(end) == min) {
        	   end = lastPosToChar.keySet().iterator().next();
           }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}
    
}
