package tasks.leetcode;

public class RectangleOverlap {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec1[2] > rec2[0] && rec1[1] < rec2[3] && rec1[3] > rec2[1];
    }

    public static void main(String[] args) {
        boolean res = isRectangleOverlap(new int[]{206110757,199595273,851054072,983256382}, new int[]{-898677230,-47320317,-858614307,736177810});
        System.out.println(res);
    }
}
