package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int[] small;
        int[] large;
        if (nums1.length < nums2.length) {
            small = nums1;
            large = nums2;
        } else {
            small = nums2;
            large = nums1;
        }
        for (int i = 0; i < small.length; i++) {
            set.add(small[i]);
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < large.length; i++) {
            if (set.contains(large[i])) {
                list.add(large[i]);
                set.remove(large[i]);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

}
