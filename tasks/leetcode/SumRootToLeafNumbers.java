package tasks.leetcode;

public class SumRootToLeafNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        total = 0;
        trace(root, 0);
        return total;
    }

    public int total = 0;

    public void trace(TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            total += (sum*10 + root.val);
            return;
        }
        trace(root.left,  sum*10 + root.val);
        trace(root.right, sum*10 + root.val);
    }


    public static void main(String[] args) {
        TreeNode tn = new TreeNode(0);
        tn.left = new TreeNode(1);
        /*tn.left = new TreeNode(2);

        tn.left.left = new TreeNode(1);
        tn.left.right = new TreeNode(3);

        tn.left.right.right = new TreeNode(4);*/

        //System.out.println(sumNumbers(tn));


    }
}
