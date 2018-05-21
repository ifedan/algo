package tasks.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            map1.merge(i, 1, (a,b)-> a + b);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums2) {
            map2.merge(i, 1, (a,b)-> a + b);
        }

        Map<Integer, Integer> small = map1.size() < map2.size() ? map1 : map2;
        Map<Integer, Integer> large = map1.size() < map2.size() ? map2 : map1;
        for (Iterator<Map.Entry<Integer, Integer>> it = small.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = it.next();
            Integer count = large.get(entry.getKey());
            if (count == null) it.remove();
            else entry.setValue(Math.min(entry.getValue(), count));
        }

        return small.entrySet().stream().
                flatMap(e -> Stream.iterate(e.getKey(), t->t).limit(e.getValue())).
                mapToInt(t->t).toArray();
    }

    public static void main(String[] args) {
        int[] a = new int[]{21,47,80,4,3,24,87,12,22,11,48,6,89,80,74,71,74,55,58,56,4,98,40,66,49,53,62,27,3,66,78,24,48,69,88,12,80,63,98,65,46,35,72,5,64,72,7,29,37,3,2,75,44,93,79,78,13,39,85,26,15,41,87,47,29,93,41,74,6,48,17,89,27,61,2,68,99,57,45,73,25,33,38,32,58};
        int[] b = new int[]{1,39,6,81,85,10,38,22,0,89,57,93,58,69,65,80,84,24,27,54,37,36,26,88,2,7,24,36,51,5,74,57,45,56,55,67,25,33,78,49,16,79,74,80,36,27,89,49,64,73,96,60,92,31,98,72,22,31,0,93,70,87,80,66,75,69,81,52,94,90,51,90,74,36,58,38,50,9,64,55,4,21,49,60,65,47,67,8,38,83};
        intersect(a, b);

        /*int[] x = new int[]{21,47,80,4,24,87,22,6,89,80,74,74,55,58,56,98,66,49,27,78,24,69,88,80,65,72,5,64,7,37,2,75,93,79,39,85,26,93,74,89,27,57,45,73,25,33,38,58};
        int[] y = new int[]{2,4,5,6,7,21,22,24,24,25,26,27,27,33,37,38,39,45,47,49,55,56,57,58,58,64,65,66,69,72,73,74,74,75,78,79,80,80,85,87,88,89,89,93,93,98};

        Arrays.sort(x);
        Arrays.sort(y);

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));*/
    }

}
