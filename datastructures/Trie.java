package datastructures;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    class Node {
        Map<Character, Node> children = new HashMap<Character, Node>();
        boolean isLeaf;
    }

    private Node root = new Node();

    public void insert(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            Node child = node.children.get(word.charAt(i));
            if (child == null) {
                child = new Node();
                node.children.put(word.charAt(i), child);
            }
            if (i == word.length() - 1) {
                child.isLeaf = true;
            }
            node = child;
        }
    }

    public boolean contains(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            Node child = node.children.get(word.charAt(i));
            if (child == null) {
                return false;
            }
            node = child;
        }
        return node.isLeaf;
    }
}
