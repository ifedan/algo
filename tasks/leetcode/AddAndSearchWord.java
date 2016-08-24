package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWord {

    class Node {
        char c;
        boolean isLeaf;
        int len;
        Map<Character, Node> map = new HashMap<Character, Node>();
    }

    Node root = new Node();

    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            Node child = node.map.get(c);
            if (child == null) {
                child = new Node();
                child.c = c;
                node.map.put(c, child);
            }
            node = child;
        }
        node.isLeaf = true;
        node.len = word.length();
    }

    public boolean search(String word) {
        return search(word, root, 0, 0);
    }

    public boolean search(String s, Node root, int start, int len) {
        Node node = root;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (node.map.isEmpty()) {
                    return false;
                } else {
                    for (Node next : node.map.values()) {
                        if (search(s, next, i+1, len+1)) {
                            return true;
                        }
                    }
                }
            } else {
                Node child = node.map.get(c);
                if (child == null) return false;
                len++;
                node = child;
            }
        }
        return node.isLeaf && s.length() == node.len;
    }

}
