package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        gather(root, result, new ArrayList<>());
        return result;
    }

    private static void gather(TreeNode node, List<String> result, List<Integer> output) {
        if (node == null) return;
        output.add(node.val);
        if (node.left == null && node.right == null) {
            result.add(toString(output));
        }
        gather(node.left, result, output);
        gather(node.right, result, output);
        output.remove(output.size()-1);
    }

    private static String toString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size()-1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(3);
        r.left.right = new TreeNode(5);
        binaryTreePaths(r);
    }

}
