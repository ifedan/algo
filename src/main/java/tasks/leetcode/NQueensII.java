package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NQueensII {

    public static int totalNQueens(int n) {
        AtomicInteger ai = new AtomicInteger();
        solveNQueens(n, 1, new ArrayList<Pos>(), ai);
        return ai.get();
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
    }

    public static void solveNQueens(int n, int row, List<Pos> positions, AtomicInteger ai) {
        if (positions.size() == n) {
            ai.incrementAndGet();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValidPos(row, col, positions)) {
                positions.add(new Pos(row, col));
                solveNQueens(n, row+1, positions, ai);
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

}
