package tasks.leetcode;

import java.util.*;

public class ShortestDistanceFromAllBuildings {

    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings test = new ShortestDistanceFromAllBuildings();
        test.shortestDistance(new int[][]{
                {1,1,1,1,1,0},
                {0,0,0,0,0,1},
                {0,1,1,0,0,1},
                {1,0,0,1,0,1},
                {1,0,1,0,0,1},
                {1,0,0,0,0,1},
                {0,1,1,1,1,0}

                /*{1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}*/
        });

    }

    public int shortestDistance(int[][] grid) {
        int houseTotalCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    houseTotalCount++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, shortestDistance(grid, i, j, houseTotalCount));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int shortestDistance(int[][] grid, int i, int j, int houseTotalCount) {
        Queue<Pos> queue = new LinkedList<>();
        Set<Pos> visited = new HashSet<>();
        Set<Pos> buildings = new HashSet<>();
        queue.offer(new Pos(i, j, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pos pos = queue.poll();
                if (visited.contains(pos)) {
                    continue;
                }
                visited.add(pos);
                if (isBuilding(grid, pos)) {
                    buildings.add(pos);
                    if (buildings.size() == houseTotalCount) {
                        return calcPath(buildings);
                    }
                    continue;
                }
                Pos p1 = new Pos(pos.i-1, pos.j, pos.dist+1);
                if (isValid(grid, p1)) {
                    queue.offer(p1);
                }
                Pos p2 = new Pos(pos.i+1, pos.j,pos.dist+1);
                if (isValid(grid, p2)) {
                    queue.offer(p2);
                }
                Pos p3 = new Pos(pos.i, pos.j-1, pos.dist+1);
                if (isValid(grid, p3)) {
                    queue.offer(p3);
                }
                Pos p4 = new Pos(pos.i, pos.j+1, pos.dist+1);
                if (isValid(grid, p4)) {
                    queue.offer(p4);
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private static boolean isBuilding(int[][] grid, Pos pos) {
        return grid[pos.i][pos.j] == 1;
    }

    private static boolean isValid(int[][] grid, Pos pos) {
        if (pos.i < 0 || pos.j < 0 || pos.i >= grid.length || pos.j >= grid[pos.i].length) {
            return false;
        }
        if (grid[pos.i][pos.j] == 2) { //obstacle
            return false;
        }
        return true;
    }

    private static int calcPath(Set<Pos> visitedHouses) {
        int path = 0;
        for (Pos house : visitedHouses) {
            path += house.dist;
        }
        return path;
    }

    class Pos {
        int i;
        int j;
        int dist;

        public Pos(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pos pos = (Pos) o;

            if (i != pos.i) return false;
            return j == pos.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

}
