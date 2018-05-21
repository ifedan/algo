package tasks.tree;

import java.util.List;

public class RootToLeafSum {

    static class Node {
        Node left;
        Node right;
        int val;
    }

    public static boolean solve(Node node, int sum, List<Node> path) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                path.add(node);
                return true;
            }
            return false;
        }

        if (solve(node.left, sum - node.val, path) || solve(node.right, sum - node.val, path)) {
            path.add(node);
            return true;
        }

        return false;
    }

}
