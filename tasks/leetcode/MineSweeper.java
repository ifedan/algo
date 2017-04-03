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
        int h = board.length;
        int w = board[0].length;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            int count = 0;
            int added = 0;
            for (int i=-1; i<=1; i++) {
                for (int j = -1; j<=1; j++) {
                    if (i == 0 && j == 0) continue;
                    int x1 = x+i;
                    int y1 = y+j;
                    if (x1 < 0 || y1 < 0 || x1 >= h || y1 >= w) continue;
                    if (board[x1][y1] == 'M') {
                        count++;
                        continue;
                    }
                    if (count == 0 && board[x1][y1] == 'E') {
                        queue.add(new int[]{x1, y1});
                        added++;
                    }
                }
            }
            if (added > 0) {
                Iterator<int[]> it = queue.descendingIterator();
                for (int i = 0; i < added; i++) {
                    int[] addedPos = it.next();
                    if (count == 0) {
                        board[addedPos[0]][addedPos[1]] = 'B';
                    } else {
                        it.remove();
                    }
                }
            }
            if (count > 0) {
                board[x][y] = Character.forDigit(count, 10);
            } else {
                board[x][y] = 'B';
            }
        }
        return board;
    }
}
