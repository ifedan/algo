package algos.search;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {

    static class Node {
        int val;
        Node[] children;

        Node(int i) {
            this.val = i;
        }

        int i = 0;
        boolean hasNext() {
            return children != null && i < children.length;
        }
        Node next() {
            this.i = i + 1;
            return children[i-1];
        }
    }

    public void traverse(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        visited.add(root);
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node.hasNext()) {
                Node next = node.next();
                if (!visited.contains(next)) {
                    visited.add(next);
                    stack.push(next);
                }
            } else {
                Node n = stack.pop();
                System.out.println("visited: " + n.val);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new Node[]{new Node(2), new Node(3)};
        root.children[1].children = new Node[]{new Node(4)};
        DFS t = new DFS();
        t.traverse(root);
    }

}
