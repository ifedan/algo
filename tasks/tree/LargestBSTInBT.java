package tasks.tree;

public class LargestBSTInBT {

    static class Node {
        Node left;
        Node right;
        int val;
        Node(int v) {val = v;}
    }

    static class Result {
        boolean isBST = true;
        int size = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    public static Result solve(Node node) {
        if (node == null) {
            return new Result();
        }
        Result left = solve(node.left);
        Result right = solve(node.right);

        Result res = new Result();
        if (!left.isBST || !right.isBST || left.max >= node.val || right.min <= node.val) {
            res.isBST = false;
            res.size = Math.max(left.size, right.size);
            return res;
        }

        res.size = left.size + right.size + 1;
        res.min = Math.min(left.min, node.val);
        res.max = Math.max(right.max, node.val);
        return res;
    }

}
