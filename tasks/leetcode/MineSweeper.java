package tasks.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MineSweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        Set<Long> visited = new HashSet<>();
        Queue<Long> queue = new LinkedList<>();
        long pos = toLong(click[0], click[1]);
        queue.add(pos);
        while (!queue.isEmpty()) {
            pos = queue.poll();
            visited.add(pos);
            int x = (int) (pos>>32);
            int y = (int) pos;
            int count = 0;
            for (int i=-1; i<=1; i++) {
                for (int j=-1; j<=1; j++) {
                    if (has(board, x+i, y+j,'M')) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                board[x][y] = Character.forDigit(count, 10);
            } else {
                for (int i=-1; i<=1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (has(board, x+i, y+j,'E')) {
                            board[x+i][y+j] = 'B';
                            pos = toLong(x+i, y+j);
                            if (!visited.contains(pos)) {
                                queue.offer(pos);
                            }
                        }
                    }
                }
            }

        }
        return board;
    }

    private boolean has(char[][] board, int x, int y, char expected) {
        return x >= 0 && y >= 0 && x < board.length && y < board[x].length && board[x][y] == expected;
    }

    private long toLong(int x, int y) {
        return ((long)x)<<32 | y;
    }
  }
