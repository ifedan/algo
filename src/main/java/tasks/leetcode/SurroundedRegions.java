package tasks.leetcode;

import java.util.Set;

public class SurroundedRegions {

    public static void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) {
            return;
        }

        for (int i  = 0; i < board.length; i++) {
            fill(i, 0, board);
            fill(i, board[i].length-1, board);
        }

        for (int j = 0; j < board[0].length; j++) {
            fill(0, j, board);
            fill(board.length-1, j, board);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }

        System.out.println();
    }

    private static void fill(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if (board[x][y] == 'X') return;
        if (board[x][y] == '1') return;

        if (board[x][y] == 'O') {
            board[x][y] = '1';
        }
        fill(x-1, y, board);
        fill(x+1, y, board);
        fill(x, y-1, board);
        fill(x, y+1, board);

    }

    public static void main(String[] args) {
        char[][] b = new char[][]{{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        solve(b);
    }

}
