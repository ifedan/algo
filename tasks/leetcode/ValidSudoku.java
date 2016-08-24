package tasks.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int h = board.length;
        int w = board[0].length;

        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < h; i++) {
            set.clear();
            for (int j = 0; j < w; j++) {
                if (board[i][j] == '.') continue;
                if (board[i][j] < '1' || board[i][j] > '9') return false;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        for (int j = 0; j < w; j++) {
            set.clear();
            for (int i = 0; i < h; i++) {
                if (board[i][j] == '.') continue;
                if (board[i][j] < '1' || board[i][j] > '9') return false;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        for (int i = 0; i < w; i+=3) {
            for (int j = 0; j < h; j+=3) {
                set.clear();
                for (int k =0; k < 3; k++) {
                    for (int m =0; m < 3; m++) {
                        if (board[i+k][j+m] == '.') continue;
                        if (set.contains(board[i+k][j+m])) {
                            return false;
                        }
                        set.add(board[i+k][j+m]);
                    }
                }
            }
        }
        return true;
    }

}
