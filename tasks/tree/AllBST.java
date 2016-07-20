package tasks.tree;

import java.util.LinkedList;
import java.util.List;

public class AllBST {

    static class Node {
        Node left;
        Node right;
    }

    public static List<Node> solve(int start, int end) {
        List<Node> nodes = new LinkedList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        for (int i = start; i <= end; i++) {
            List<Node> lefts = solve(start, i-1);
            List<Node> rights = solve(i+1, end);

            for (Node left : lefts) {
                for (Node right : rights) {
                    Node node = new Node();
                    node.left = left;
                    node.right = right;
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }



}
