package tasks.leetcode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class TreeNodeWithId {
        TreeNode node;
        int id;
        TreeNodeWithId(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNodeWithId> queue = new LinkedList<>();
        queue.offer(new TreeNodeWithId(root, 0));
        while (!queue.isEmpty()) {
            TreeNodeWithId entry = queue.poll();
            map.compute(entry.id, (k, v) -> {
                if (v == null) v = new ArrayList<>();
                v.add(entry.node.val);
                return v;
            });
            if (entry.node.left != null) {
                queue.offer(new TreeNodeWithId(entry.node.left, entry.id-1));
            }
            if (entry.node.right != null) {
                queue.offer(new TreeNodeWithId(entry.node.right, entry.id+1));
            }
        }
        return new ArrayList<>(map.values());
    }
}
