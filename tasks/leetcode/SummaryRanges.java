package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) return result;
        int start = nums[0];
        boolean link = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                link = true;
                continue;
            } else {
                if (link) {
                    result.add(start + "->" + nums[i-1]);
                    link = false;
                } else {
                    result.add(""+nums[i-1]);
                }
                start = nums[i];
            }
        }
        if (link) {
            result.add(start + "->" + nums[nums.length-1]);
        } else {
            result.add(""+nums[nums.length-1]);
        }
        return result;
    }
}
