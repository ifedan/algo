package tasks.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return bfs(root);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return bfs(data);
        }

        private String bfs(TreeNode node) {
            if (node == null) return null;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(node);
            StringBuilder sb = new StringBuilder();
            boolean hasEntry = true;
            while (!queue.isEmpty() && hasEntry) {
                hasEntry = false;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode n = queue.poll();
                    sb.append(n != null ? n.val : "null");
                    sb.append(',');
                    if (n != null) {
                        queue.offer(n.left);
                        queue.offer(n.right);
                        hasEntry = hasEntry | n.left != null | n.right != null;
                    }
                }

            }
            if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            if (sb.lastIndexOf("null") == sb.length() - 4) {
                sb.delete(sb.length() - 5, sb.length());
            }
            return sb.toString();
        }

        private TreeNode bfs(String str) {
            if (str == null) return null;
            String[] values = str.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty() && i < values.length) {
                TreeNode node = queue.poll();
                String left = values[i++];
                String right = i < values.length ? values[i++] : "null";
                if (!"null".equals(left)) {
                    node.left = new TreeNode(Integer.parseInt(left));
                    queue.offer(node.left);
                }
                if (!"null".equals(right)) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }

}
