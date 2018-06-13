package tasks.leetcode;

public class LargestTriangleArea {
    public static double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i <= points.length - 3; i ++) {
            for (int j = i+1; j <= points.length - 2; j++) {
                for (int k = j+1; k <= points.length - 1; k++) {
                    int aX = points[i][0];
                    int aY = points[i][1];
                    int bX = points[j][0];
                    int bY = points[j][1];
                    int cX = points[k][0];
                    int cY = points[k][1];
                    double area = aX*(bY-cY) + bX*(cY-aY) + cX*(aY-bY);
                    max = Math.max(Math.abs(area), max);
                }
            }
        }
        return max/2;
    }

    public static void main(String[] args) {
        double res = largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}});
        System.out.println(res);
    }
}
