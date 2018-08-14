package tasks.leetcode;

import java.util.*;

public class FindDuplicateSubtrees {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    Map<String, Integer> duplicates = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        bfs(root);
        return result;
    }

    private String bfs(TreeNode root) {
        if (root == null) return "null";

        String left = bfs(root.left);
        String right = bfs(root.right);

        String key = root.val + ";" + left + ";" + right;
        duplicates.merge(key, 1, (val, acc) -> val+acc);
        if (duplicates.get(key) == 2) {
            result.add(root);
        }

        return key;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(0);

        t1.left = t2;
        t2.left = t3;
        t1.right = t4;
        t4.right = t5;
        t5.right = t6;

        FindDuplicateSubtrees test = new FindDuplicateSubtrees();
        test.findDuplicateSubtrees(t1);
    }

}
