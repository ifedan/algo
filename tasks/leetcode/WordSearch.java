package tasks.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Set<Long> visited = new HashSet<>();
                if (exist(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word, int index, int i, int j, Set<Long> visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 | i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        long id = ((long)i<<32)|j;
        if (visited.contains(id)) {
            return false;
        }
        visited.add(id);

        if (exist(board, word, index+1, i+1, j, visited)) {
            return true;
        }
        if (exist(board, word, index+1, i, j+1, visited)) {
            return true;
        }
        if (exist(board, word, index+1, i-1, j, visited)) {
            return true;
        }
        if (exist(board, word, index+1, i, j-1, visited)) {
            return true;
        }

        visited.remove(id);
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}

        };

        boolean res = exist(board, "ABCESEEEFS");
        System.out.println(res);
    }

}
