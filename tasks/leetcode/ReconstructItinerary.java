package tasks.leetcode;

import java.util.*;

public class ReconstructItinerary {

  public List<String> findItinerary(String[][] tickets) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            Set<String> to = map.get(ticket[0]);
            if (to == null) {
                to = new LinkedHashSet<>();
                map.put(ticket[0], to);
            }
            to.add(ticket[1]);
        }

        List<String> result = new ArrayList<>();
        result.add("JFK");
        dfs("JFK", map, result, tickets.length+1);
        return result;
    }

    private boolean dfs(String name, Map<String, Set<String>> map, List<String> result, int size) {
        if (result.size() == size) {
            return true;
        }
        if (!map.containsKey(name) || map.get(name).isEmpty()) {
            return false;
        }

        Set<String> to = map.get(name);

        for (int i = 0; i < to.size(); i++) {
            Iterator<String> it = to.iterator();
            String next = it.next();
            it.remove();
            result.add(next);

            if (dfs(next, map, result, size)) {
                return true;
            }

            result.remove(result.size() - 1);
            to.add(next);
        }
        return false;
    }
}
