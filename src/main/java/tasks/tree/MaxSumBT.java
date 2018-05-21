package tasks.tree;

public class MaxSumBT {

    static class Node {
        Node left;
        Node right;
        int val;
    }

    static int maxPath = Integer.MIN_VALUE;

    public static int solve(Node node) {
        int left;
        int right;
        int tree = node.val;
        if (node.left != null) {
            left = solve(node.left)+node.val;
            tree += left;
        } else {
            left = Integer.MIN_VALUE;
        }
        if (node.right != null) {
            right = solve(node.right)+node.val;
            tree += right;
        } else {
            right = Integer.MIN_VALUE;
        }

        int maxHere = Math.max(node.val, Math.max(left, right));
        maxPath = Math.max(maxPath, Math.max(maxHere, tree));
        return maxHere;
    }


}
