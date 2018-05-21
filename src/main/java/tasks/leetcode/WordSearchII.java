package tasks.leetcode;

import java.util.*;

public class WordSearchII {

    static class Node {
        char c;
        boolean isLeaf;
        Map<Character, Node> children = new HashMap<Character, Node>();
    }

    static class Trie {
        Node root = new Node();

        void insert(String s) {
            Node node = root;
            for (char c : s.toCharArray()) {
                Node child = node.children.get(c);
                if (child == null) {
                    child = new Node();
                    child.c = c;
                    node.children.put(c, child);
                }
                node = child;
            }
            node.isLeaf = true;
        }

        Node getRoot() {
            return root;
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        int maxSize = 0;
        Trie trie = new Trie();
        for (String word : words) {
            maxSize = Math.max(maxSize, word.length());
            trie.insert(word);
        }
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                trace(trie.getRoot(), board, i, j, maxSize, 0, new HashSet<Long>(), new StringBuilder(), result);
            }
        }
        return new ArrayList<String>(result);
    }

    public static void trace(Node node, char[][] board, int i, int j, int maxSize, int size, Set<Long> visited, StringBuilder sb, Set<String> result) {
        long id = (long)i<<32 | j;
        if (visited.contains(id)) return;
        if (size > maxSize) return;
        Node child = node.children.get(board[i][j]);
        if (child == null) return;

        visited.add(id);
        sb.append(board[i][j]);
        if (child.isLeaf) {
            result.add(sb.toString());
        }

        if (i > 0) trace(child, board, i-1, j, maxSize, size+1, visited, sb, result);
        if (i < board.length-1) trace(child, board, i+1, j, maxSize, size+1, visited, sb, result);
        if (j > 0) trace(child, board, i, j-1, maxSize, size+1, visited, sb, result);
        if (j < board[i].length-1) trace(child, board, i, j+1, maxSize, size+1, visited, sb, result);

        sb.deleteCharAt(sb.length()-1);
        visited.remove(id);
    }

}
