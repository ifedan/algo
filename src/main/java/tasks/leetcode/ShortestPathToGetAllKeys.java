package tasks.leetcode;

import java.util.*;

public class ShortestPathToGetAllKeys {

    public static void main(String[] args) {
        int res = shortestPathAllKeys(new String[]{ ".#......###..#.",
                                                    ".###C..#...b...",
                                                    "..#..#.........",
                                                    ".........#.....",
                                                    ".....@#.#......",
                                                    "#.##...#..##...",
                                                    "..d#...a...#...",
                                                    "..###..........",
                                                    "........#....#.",
                                                    "..#.#..#...c#.#",
                                                    "D#..........#.#",
                                                    "............#A.",
                                                    "..#..##...#....",
                                                    "#...#..#..B....",
                                                    ".....##.....#.."});
        System.out.println(res);
    }

    public static int shortestPathAllKeys(String[] grid) {
        int keyCount = 0;
        int x = -1;
        int y = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (Character.isLowerCase(grid[i].charAt(j))) {
                    keyCount++;
                }
                if ('@' == grid[i].charAt(j)) {
                    x = i;
                    y = j;
                }
            }
        }
        int res = solve(grid, new Position(x, y, 0), (1<<keyCount) - 1);
        return res;
    }

    public static int solve(String[] grid, Position start, int allKeys) {
        Queue<Position> queue = new LinkedList<>();
        Set<Position> visited = new HashSet<>();
        queue.offer(start);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Position> toAdd = new HashSet<>();
            for (int i = 0; i < size; i++) {
                Position pos = queue.poll();
                visited.add(pos);
                List<Position> next = getNextPos(grid, pos, visited);
                for (Position p : next) {
                    if (p.keys == allKeys) {
                        return level;
                    } else {
                        toAdd.add(p);
                    }
                }
            }
            queue.addAll(toAdd);
            level++;
        }
        return -1;
    }

    private static List<Position> getNextPos(String[] grid, Position pos, Set<Position> visited) {
        List<Position> next = new ArrayList<>();
        addIfNotVisited(nextPos(grid, pos, pos.i-1, pos.j), next, visited);
        addIfNotVisited(nextPos(grid, pos, pos.i+1, pos.j), next, visited);
        addIfNotVisited(nextPos(grid, pos, pos.i, pos.j-1), next, visited);
        addIfNotVisited(nextPos(grid, pos, pos.i, pos.j+1), next, visited);
        return next;
    }

    private static void addIfNotVisited(Position pos, List<Position> col, Set<Position> visited) {
        if (pos != null && !visited.contains(pos)) {
            col.add(pos);
        }
    }

    private static Position nextPos(String[] grid, Position pos, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length()) {
            return null;
        }
        char c = grid[i].charAt(j);
        if (c == '#') {
            return null;
        }
        if (Character.isUpperCase(c) && !hasKey(pos.keys, c)) {
            return null;
        }
        int keys = pos.keys;
        if (Character.isLowerCase(c)) {
            keys = addKey(keys, c);
        }
        return new Position(i, j, keys);
    }

    private static boolean hasKey(int keys, char door) {
        return (1 & (keys >> (door - 'A'))) == 1;
    }

    private static int addKey(int keys, char key) {
        return keys | (1 << (key - 'a'));
    }

    static class Position {
        int i;
        int j;
        int keys;
        Position(int i, int j, int keys) {
            this.i = i;
            this.j = j;
            this.keys = keys;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (i != position.i) return false;
            if (j != position.j) return false;
            return keys == position.keys;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            result = 31 * result + keys;
            return result;
        }

        public String toString() {
            return "i="+i+" j="+j+" key="+keys;
        }
    }
}
