package datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * User: ifedan
 * Date: 4/21/15
 */
public class Trie
{

    private static class Node {
        Character ch;
        Map<Character, Node> children = new HashMap<Character, Node>();
        boolean end;

        Node(Character c) {
            this.ch = c;
        }
    }

    private Node root;

    public Trie() {
        root = new Node(null);
    }

    public void insert(String word) {
        Node root = this.root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            Node child = root.children.get(c);
            if (child == null) {
                child = new Node(c);
                root.children.put(c, child);
            }
            root = child;
        }
        root.end = true;
    }

    public String search(String word) {
        Node root = this.root;
        StringBuffer sb = new StringBuffer();
        int lastWord = 0;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            Node child = root.children.get(c);
            if (child == null) {
                break;
            }
            sb.append(c);
            if (child.end) {
                lastWord = i;
            }
            root = child;
        }
        return sb.substring(0, lastWord+1);
    }
}
