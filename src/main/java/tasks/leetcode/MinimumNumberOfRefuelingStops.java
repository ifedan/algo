package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfRefuelingStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            return target > startFuel ? -1 : 0;
        } else if (stations[0][0] > startFuel){
            return -1;
        }
        int result = minRefuelStops(0, target, startFuel - stations[0][0], stations, 0, new HashMap<>());
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int minRefuelStops(int currentStation, int target, int fuel, int[][] stations, int stops, Map<Long, Integer> stopsCache) {
        if (fuel < 0) {
            return Integer.MAX_VALUE;
        }
        if (currentStation == stations.length - 1) {
            if (target - stations[currentStation][0] <= fuel) return stops;
            else if (target - stations[currentStation][0] <= fuel + stations[currentStation][1]) return stops + 1;
            else return Integer.MAX_VALUE;
        }

        long pos = (((long)currentStation)<<32) | fuel;
        Integer cached = stopsCache.get(pos);
        if (cached != null) {
            return cached == Integer.MAX_VALUE ? cached : stops + cached;
        }

        int nextStation = currentStation + 1;
        int distanceToNextStation = stations[nextStation][0] - stations[currentStation][0];

        int m1 = minRefuelStops(nextStation, target, fuel - distanceToNextStation, stations, stops, stopsCache);
        int m2 = minRefuelStops(nextStation, target, fuel + stations[currentStation][1] - distanceToNextStation, stations, stops+1, stopsCache);

        int min = Math.min(m1, m2);

        if (min == Integer.MAX_VALUE) {
            stopsCache.put(pos, Integer.MAX_VALUE);
        } else {
            stopsCache.put(pos, min - stops);
        }

        return min;
    }

    public static int minRefuelStops2(int target, int startFuel, int[][] stations) {
        long[] dp = new long[stations.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; i++) {
            for (int j = i; j >= 0 && dp[j] >= stations[i][0]; j--) {
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
            }
        }

        for (int i = 0; i <= stations.length; i++)
            if (dp[i] >= target) return i;
        return -1;
    }

    public static void main(String[] args) {
        //int r = minRefuelStops2(1000, 83, new int[][]{{47,220},{65,1},{98,113},{126,196},{186,218},{320,205},{686,317},{707,325},{754,104},{781,105}});
        int r = minRefuelStops2(100, 10, new int[][]{{10,60},{20,30},{30,30},{60,40}});
        System.out.println(r);
    }
}
