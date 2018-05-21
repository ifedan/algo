package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            TrieNode child = node.children.get(c);
            if (child == null) {
                child = new TrieNode();
                child.c = c;
                node.children.put(c, child);
            }
            node = child;
        }
        node.isLeaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            TrieNode child = node.children.get(c);
            if (child == null) return false;
            node = child;
        }
        return node != null && node.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            TrieNode child = node.children.get(c);
            if (child == null) return false;
            node = child;
        }
        return node != null;
    }

}
class TrieNode {
    // Initialize your data structure here.
    char c;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;

    public TrieNode() {

    }
}