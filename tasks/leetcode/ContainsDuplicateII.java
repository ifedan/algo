package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else {
                if (i-index <= k) return true;
                else map.put(nums[i], i);
            }
        }
        return false;
    }

}
