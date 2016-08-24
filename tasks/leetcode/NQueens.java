package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        solveNQueens(n, 1, new ArrayList<Pos>(), result);
        return result;
    }

    static class Pos {
        int r;
        int c;
        int rmc;
        int rpc;
        Pos(int row, int col) {
            this.r = row;
            this.c = col;
            this.rmc = row - col;
            this.rpc = row + col;
        }
        boolean canBeat(int row, int col, int rmc ,int rpc) {
            return this.r == row || this.c == col || this.rmc == rmc || this.rpc == rpc;
        }
        String toString(int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (c != i) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            return sb.toString();
        }
    }

    public static void solveNQueens(int n, int row, List<Pos> positions, List<List<String>> result) {
        if (positions.size() == n) {
            result.add(toString(positions, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValidPos(row, col, positions)) {
                positions.add(new Pos(row, col));
                solveNQueens(n, row+1, positions, result);
                positions.remove(positions.size()-1);
            }
        }
    }

    private static boolean isValidPos(int row, int col, List<Pos> positions) {
        int rmc = row - col;
        int rpc = row + col;
        for (Pos p : positions) {
            if (p.canBeat(row, col, rmc, rpc)) return false;
        }
        return true;
    }

    private static List<String> toString(List<Pos> positions, int n) {
        List<String> list = new ArrayList<String>(n);
        for (Pos p : positions) {
            list.add(p.toString(n));
        }
        return list;
    }

}
