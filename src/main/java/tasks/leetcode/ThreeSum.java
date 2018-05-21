package tasks.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                while (l < r) {
                    int s = nums[l] + nums[r] + nums[i];
                    if (s == 0) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));

                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        l++; r--;

                    } else if (s > 0) r--;
                    else l++;
                }
            }
        }
        return result;
    }

}
