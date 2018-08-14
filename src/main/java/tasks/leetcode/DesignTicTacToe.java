package tasks.leetcode;

public class DesignTicTacToe {

    public static void main(String[] args) {
        /*
        ["TicTacToe","move","move","move"]
[[2],[0,0,2],[0,1,1],[1,1,2]]
         */
        TicTacToe ttt = new TicTacToe(2);
        ttt.move(0,0, 2);
        ttt.move(0,1, 1);
        ttt.move(1, 1, 2);
    }

    static class TicTacToe {

        int[] horizontal;
        int[] vertical;
        int[] diagonal1;
        int[] diagonal2;

        int n;
        int count = 0;
        boolean stop = false;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.horizontal = new int[n];
            this.vertical = new int[n];
            this.diagonal1 = new int[1];
            this.diagonal2 = new int[1];
            this.n = n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int outcome = markHorizontal(row, player, n);
            if (outcome != 0) return outcome;

            outcome = markVertical(col, player, n);
            if (outcome != 0) return outcome;

            if (row == col) {
                outcome = markDiagonal1(player, n);
            }
            if (outcome != 0) return outcome;

            if (row + col == n - 1) {
                outcome = markDiagonal2(player, n);
            }
            if (outcome != 0) return outcome;

            return 0;
        }

        private int mark(int x, int[] arr, int player, int n) {
            if (arr[x] != Integer.MAX_VALUE) {
                if (player == 1) {
                    if (arr[x] >= 0) {
                        arr[x]++;
                    } else {
                        arr[x] = Integer.MAX_VALUE;
                    }
                } else {
                    if (arr[x] <= 0) {
                        arr[x]--;
                    } else {
                        arr[x] = Integer.MAX_VALUE;
                    }
                }
            }
            return arr[x] == n ? 1 : (arr[x] == -n ? 2 : 0);
        }

        private int markVertical(int col, int player, int n) {
            return mark(col, vertical, player, n);
        }

        private int markHorizontal(int row, int player, int n) {
            return mark(row, horizontal, player, n);
        }

        private int markDiagonal1(int player, int n) {
            return mark(0, diagonal1, player, n);
        }

        private int markDiagonal2(int player, int n) {
            return mark(0, diagonal2, player, n);
        }
    }
}
