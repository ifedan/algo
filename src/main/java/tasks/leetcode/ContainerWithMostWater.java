package tasks.leetcode;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while (l < r) {
            int leftHeight = height[l];
            int rightHeight = height[r];
            int area = (r-l) * Math.min(leftHeight, rightHeight);
            max = Math.max(max, area);
            if (leftHeight < rightHeight) {
                while (l < r && height[l] <= leftHeight) l++;
            } else {
                while (l < r && height[r] <= rightHeight) r--;
            }
        }
        return max;
    }
}
