package tasks.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CarRace {

    public static int racecar(int target) {
        if (((target+1)&target) == 0) {
            return 31 - Integer.numberOfLeadingZeros(target + 1);
        }
        Position init = new Position(0, 1);
        Queue<Position> queue = new LinkedList<>();
        Set<Position> visited = new HashSet<>();
        queue.offer(init);
        visited.add(init);
        int operations = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position pos = queue.poll();
                if (pos.val == target) return operations;
                Position p1 = new Position(pos.val + pos.speed, pos.speed * 2);
                Position p2 = new Position(pos.val, pos.speed > 0 ? -1 : 1);
                if (!visited.contains(p1) && Math.abs(p1.val - target) < target) {
                    queue.offer(p1);
                    visited.add(p1);
                }
                if (!visited.contains(p2) && Math.abs(p2.val - target) < target) {
                    queue.offer(p2);
                    visited.add(p2);
                }
            }
            operations++;
        }

        return -1;
    }

    static class Position {
        int val;
        int speed;
        Position(int v, int s) {
            val  = v;
            speed = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (val != position.val) return false;
            return speed == position.speed;
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + speed;
            return result;
        }
    }

    public static void main(String[] args) {
        int res = racecar(5);
        System.out.println(res);
    }

}
