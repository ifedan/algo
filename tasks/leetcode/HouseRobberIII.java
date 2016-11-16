package tasks.leetcode;

public class HouseRobberIII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int rob(TreeNode root) {
        if (root == null) return 0;
        Result r = calc(root);
        return Math.max(r.incl, r.excl);
    }

    public static Result calc(TreeNode node) {
        if (node == null) {
            return new Result();
        }
        Result left = calc(node.left);
        Result right = calc(node.right);

        int incl = Math.max(left.excl + right.excl + node.val, left.incl + right.incl);
        int excl = left.incl + right.incl;

        return new Result(incl, excl);
    }

    private static class Result {
        int incl;
        int excl;
        Result(int i, int e) {
            this.incl = i;
            this.excl = e;
        }
        Result() {
            incl = 0;
            excl = 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));

        //solve(new int[]{3, 2, 1});
    }

}
