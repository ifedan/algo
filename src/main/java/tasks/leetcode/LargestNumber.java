package tasks.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        boolean onlyZero = true;
        for (int i = 0; i < nums.length; i++) {
            str[i] = Integer.toString(nums[i]);
            if (nums[i] != 0) onlyZero = false;
        }
        if (onlyZero) return "0";
        Arrays.sort(str, new Comp());
        StringBuilder sb = new StringBuilder();
        for (int i = str.length-1; i>= 0; i--) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    static class Comp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            long a = Long.valueOf(o1+o2);
            long b = Long.valueOf(o2+o1);
            return a > b ? 1 : -1;
        }
    }

}
