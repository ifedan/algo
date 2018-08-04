package tasks.leetcode;

import java.util.Set;

public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board.length == 0) return;
        fillRow(board, 0, 'O', 'Y');
        fillRow(board, board.length - 1, 'O', 'Y');
        fillCol(board, 0, 'O', 'Y');
        fillCol(board, board[0].length - 1, 'O', 'Y');

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    fill(board, i, j, 'O', 'X');
                }
            }
        }

        fillRow(board, 0, 'Y', 'O');
        fillRow(board, board.length - 1, 'Y', 'O');
        fillCol(board, 0, 'Y', 'O');
        fillCol(board, board[0].length - 1, 'Y', 'O');
    }

    private void fillRow(char[][] board, int row, char curr, char next) {
        for (int j = 0; j < board.length; j++) {
            fill(board, row, j, curr, next);
        }
    }

    private void fillCol(char[][] board, int col, char curr, char next) {
        for (int i = 0; i < board.length; i++) {
            fill(board, i, col, curr, next);
        }
    }

    public void fill(char[][] board, int x, int y, char curr, char next) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }
        if (board[x][y] == 'X' || board[x][y] == next) {
            return;
        }
        if (board[x][y] == curr) {
            board[x][y] = next;
        }
        fill(board, x-1, y, curr, next);
        fill(board, x+1, y, curr, next);
        fill(board, x, y-1, curr, next);
        fill(board, x, y+1, curr, next);
    }

}
