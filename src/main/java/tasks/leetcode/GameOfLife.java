package tasks.leetcode;

public class GameOfLife {

    public static void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int lives = liveAround(i, j, board);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) board[i][j] = 3; // 1(curr)->1(next)
                if (board[i][j] == 0 && lives == 3) board[i][j] = 2; // 0(curr)->1(next)
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }


    private static int liveAround(int x, int y, int[][] board) {
        int live = 0;
        for (int i = Math.max(x-1, 0); i <= Math.min(x+1, board.length-1); i++) {
            for (int j = Math.max(y-1, 0); j <= Math.min(y+1, board[i].length - 1); j++) {
                if (i != x || j != y) live += (board[i][j] & 1);
            }
        }
        return live;
    }

}
