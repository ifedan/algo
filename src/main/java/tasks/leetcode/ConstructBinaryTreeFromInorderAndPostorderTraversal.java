package tasks.leetcode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        return buildTree2(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }

    public static TreeNode buildTree2(int[] postorder, int postLo, int postHi, int[] inorder, int inLo, int inHi) {
        if (postLo > postHi || inLo > inHi) return null;
        int root = postorder[postHi];

        TreeNode node = new TreeNode(root);
        if (inLo == inHi || postLo == postHi) {
            return node;
        }

        int i;
        for (i = inLo; i < inHi; i++) {
            if (root == inorder[i]) break;
        }
        int left = i - inLo;

        node.left = buildTree2(postorder, postLo, postLo+left-1, inorder, inLo, i-1);
        node.right = buildTree2(postorder, postLo+left, postHi-1, inorder, i+1, inHi);
        return node;
    }

}
