package tasks.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {

    static class Bus {
        Set<Integer> stops = new HashSet<>();
    }

    public static int traverse(int start, int end, Map<Integer, Set<Bus>> graph) {
        Queue<Bus> queue = new LinkedList<>();
        Set<Bus> visited = new HashSet<>();
        queue.addAll(graph.get(start));
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            while (i < size) {
                Bus bus = queue.poll();
                i++;
                if (visited.contains(bus)) continue;
                visited.add(bus);
                if (bus.stops.contains(end)) return level;
                Set<Bus> set = new HashSet<>();
                for (Integer stop : bus.stops) {
                    set.addAll(graph.getOrDefault(stop, Collections.EMPTY_SET));
                }
                set.remove(bus);
                queue.addAll(set);
            }
            level++;
        }
        return -1;
    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, Set<Bus>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            final Bus cc = new Bus();
            for (int j = 0; j < routes[i].length; j++) {
                cc.stops.add(routes[i][j]);
                map.compute(routes[i][j], (k,v) -> {
                    if (v==null) v = new HashSet<>();
                    v.add(cc);
                    return v;
                });
            }
        }
        return traverse(S, T, map);
    }

    public static void main(String[] args) {
        //int[][] arr = new int[][]{{0,1,6,16,22,23},{14,15,24,32},{4,10,12,20,24,28,33},{1,10,11,19,27,33},{11,23,25,28},{15,20,21,23,29},{29}};
        int[][] arr = new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}};
        int result = numBusesToDestination(arr, 15, 12);
        System.out.println(result);
    }

}
