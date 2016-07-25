package tasks.recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Boggle {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 't', 'p'},
                {'c', 'r', 'a'},
                {'o', 'p', 't'}
        };
        Set<String> words = new HashSet<>();
        words.add("cat");
        words.add("car");
        words.add("carat");
        words.add("rap");
        words.add("tap");
        words.add("rat");
        words.add("cora");
        words.add("or");
        words.add("roc");
        words.add("cop");
        words.add("at");
        words.add("art");
        words.add("opt");
        words.add("optt");
        words.add("rac");
        words.add("cao");

        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                solve(board, i, j, new HashSet<>(), words, result, new LinkedList<>());
            }
        }

        System.out.println(result);
    }

    public static void solve(char[][] board, int x, int y, Set<Long> visited, Set<String> words, Set<String> result, List<Character> word) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) return;

        long id = ((long)x)<<32 | y;
        if (visited.contains(id)) {
            return;
        }
        visited.add(id);
        word.add(board[x][y]);

        String w = contains(word, words);
        if (w != null) {
            result.add(w);
        }

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i==0 && j == 0) {
                    continue;
                }
                solve(board, x + i, y + j, visited, words, result, word);
            }
        }

        word.remove(word.size()-1);
        visited.remove(id);
    }

    private static String contains(List<Character> word, Set<String> words) {
        StringBuilder sb = new StringBuilder();
        for (Character c : word) {
            sb.append(c);
        }
        if (words.contains(sb.toString())) {
            return sb.toString();
        }
        return null;
    }

}
