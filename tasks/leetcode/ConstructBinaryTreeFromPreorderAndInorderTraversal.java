package tasks.leetcode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public static TreeNode buildTree(int[] preorder, int preLo, int preHi, int[] inorder, int inLo, int inHi) {
        if (preLo > preHi || inLo > inHi) return null;
        int root = preorder[preLo];
        TreeNode node = new TreeNode(root);
        if (inLo == inHi || preLo == preHi) {
            return node;
        }

        int i;
        for (i = inLo; i < inHi; i++) {
            if (root == inorder[i]) break;
        }
        int left = i - inLo;

        node.left = buildTree(preorder, preLo+1, preLo+left, inorder, inLo, i-1);
        node.right = buildTree(preorder, preLo+left+1, preHi, inorder, i+1, inHi);
        return node;
    }

}
