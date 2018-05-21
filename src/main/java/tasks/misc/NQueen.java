package tasks.misc;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    static class Position {
        int r;
        int c;
        int rmc;
        int rpc;
        Position(int r, int c) {
            this.r = r;
            this.c = c;
            this.rmc = r-c;
            this.rpc = r+c;
        }
    }

    public static void main(String[] args) {
        List<List<Position>> result = new ArrayList<>();
        solve(8, 0, new ArrayList<>(), result);
        System.out.println(result.size());;
    }

    public static void solve(int n, int row, List<Position> pos, List<List<Position>> result) {
        if (pos.size() == n) {
            result.add(pos);
            return;
        }
        for (int col = 0; col < 8; col++) {
            if (!isValid(row, col, pos)) continue;
            pos.add(new Position(row, col));
            solve(n, row + 1, pos, result);
            pos.remove(pos.size() - 1);
        }
    }

    private static boolean isValid(int row, int col, List<Position> pos) {
        int rmc = row - col;
        int rpc = row + col;
        for (Position p : pos) {
            if (intersect(row, col, rmc, rpc, p)) {
                return false;
            }
        }
        return true;
    }

    private static boolean intersect(int row, int col, int rmc, int rpc, Position pos) {
        return row == pos.r || col == pos.c || rmc == pos.rmc || rpc == pos.rpc;
    }

}
