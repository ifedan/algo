package tasks.leetcode;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<String>();
                map.put(key,  list);
            }
            list.add(strs[i]);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }

}
