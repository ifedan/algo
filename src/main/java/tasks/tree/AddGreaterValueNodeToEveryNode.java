package tasks.tree;

/**
 * http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 *
 **/
public class AddGreaterValueNodeToEveryNode {

    static class Node {
        Node left;
        Node right;
        int val;
    }

    public static void solve(Node node, int sum) {
        if (node == null) return;
        solve(node.right, sum);
        sum += node.val;
        node.val = sum;
        solve(node.left, sum);

    }

}
