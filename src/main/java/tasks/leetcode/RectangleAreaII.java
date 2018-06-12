package tasks.leetcode;

import java.util.*;

public class RectangleAreaII {

    /*
    ************ FIRST APPROACH *************
     */
    public static int rectangleArea1(int[][] rectangles) {
        if (rectangles.length == 1) {
            return (int)((long)(rectangles[0][2] - rectangles[0][0])*(rectangles[0][3]-rectangles[0][1]) % 1000000007);
        }
        TreeSet<Integer> xs = new TreeSet<>();
        TreeSet<Integer> ys = new TreeSet<>();
        for (int i = 0; i < rectangles.length; i++) {
            xs.add(rectangles[i][0]);
            xs.add(rectangles[i][2]);
            ys.add(rectangles[i][1]);
            ys.add(rectangles[i][3]);
        }
        List<Integer> xList = new ArrayList<>(xs);
        List<Integer> yList = new ArrayList<>(ys);

        Map<Integer, Integer> mapX = new HashMap<>();
        for (int i = 0; i < xList.size(); i++) {
            mapX.put(xList.get(i), i);
        }
        Map<Integer, Integer> mapY = new HashMap<>();
        for (int i = 0; i< yList.size(); i++) {
            mapY.put(yList.get(i), i);
        }
        boolean[][] board = new boolean[yList.size()][xList.size()];
        for (int i = 0; i < rectangles.length; i++) {
            fill(board, mapX.get(rectangles[i][0]), mapY.get(rectangles[i][1]), mapX.get(rectangles[i][2]), mapY.get(rectangles[i][3]));
        }
        long area = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    area += ((xList.get(j+1) - xList.get(j)) * (yList.get(i+1) - yList.get(i)));
                }
            }
        }
       return (int)(area % 1000000007);
    }

    private static void fill(boolean[][] board, int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                board[i][j] = true;
            }
        }
    }

    /*
     ************ SECOND APPROACH *************
     */
    public static int rectangleArea2(int[][] rectangles) {
        if (rectangles.length == 1) {
            return (int)((long)(rectangles[0][2] - rectangles[0][0])*(rectangles[0][3]-rectangles[0][1]) % 1000000007);
        }
        Queue<int[]> list = new LinkedList<>();
        for (int i = 0; i < rectangles.length; i++) {
            list.offer(rectangles[i]);
        }
        return (int) (calc(list) % 1000000007);
    }

    private static long calc(Queue<int[]> rectangles) {
        long area = 0;
        do {
            int[] rec1 = rectangles.poll();
            int size = rectangles.size();
            for (int i = 0; i < size; i++) {
                int[] rec2 = rectangles.poll();
                if (isInside(rec2, rec1)) {
                    continue;
                } else if (isIntersect(rec1, rec2)) {
                    List<int[]> inter = intersections(rec1, rec2);
                    rectangles.addAll(inter);
                } else {
                    rectangles.offer(rec2);
                }
            }
            area += (1L * (rec1[2] - rec1[0]) * (rec1[3] - rec1[1]));
        } while (!rectangles.isEmpty());

        return area;
    }

    private static boolean isIntersect(int[] rec1, int[] rec2) {
        return  (rec1[0] < rec2[2] && rec1[2] > rec2[0] && rec1[1] < rec2[3] && rec1[3] > rec2[1]);
    }

    //rec1 inside rec2
    private static boolean isInside(int[] rec1, int[] rec2) {
        return  rec1[0] >= rec2[0] && rec1[2] <= rec2[2] && rec1[1] >= rec2[1] && rec1[3] <= rec2[3];
    }

    private static List<int[]> intersections(int[] rec1, int[] rec2) {
        List<int[]> result = new ArrayList<>();

        //intersection
        int x1 = Math.max(rec1[0], rec2[0]);
        int y1 = Math.max(rec1[1], rec2[1]);

        int x2 = Math.min(rec1[2], rec2[2]);
        int y2 = Math.min(rec1[3], rec2[3]);

        /*
                         rec2[2], rec2[3]
        !-----!------!-----!
        !                  !
        !           x2,y2  !
        !     !------!     !
        !     !      !     !
        !     !------!     !
        !    x1,y1         !
        !                  !
        !------------------!
     rec2[0], rec2[1]
        */
        //result.add(rec1);

        if (x1 - rec2[0] > 0) {
            result.add(new int[]{rec2[0], rec2[1], x1, rec2[3]});
        }
        if (rec2[2] - x2 > 0) {
            result.add(new int[]{x2, rec2[1], rec2[2], rec2[3]});
        }
        if (x2 - x1 > 0 && y1 - rec2[1] > 0) {
            result.add(new int[]{x1, rec2[1], x2, y1});
        }
        if (x2 - x1 > 0 && rec2[3] - y2 > 0) {
            result.add(new int[]{x1, y2, x2, rec2[3]});
        }

        return result;
    }

    public static void main(String[] args) {
        rectangleArea1(new int[][]{{0,0,3,3},{2,0,5,3},{1,1,4,4}});
        rectangleArea2(new int[][]{{0,0,3,3},{2,0,5,3},{1,1,4,4}});
    }
}
