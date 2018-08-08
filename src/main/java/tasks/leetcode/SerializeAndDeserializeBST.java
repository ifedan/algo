package tasks.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SerializeAndDeserializeBST {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int v) {
            this.val = v;
        }
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "null";
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            StringBuffer sb = new StringBuffer();
            sb.append(root.val);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    sb.append(";");
                    sb.append(node.left.val);
                } else {
                    sb.append(";null");
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    sb.append(";");
                    sb.append(node.right.val);
                } else {
                    sb.append(";null");
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            StringTokenizer st = new StringTokenizer(data, ";");
            String val = st.nextToken();
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = null;
            if ("null".equals(val)) {
                root = null;
            } else {
                root = new TreeNode(Integer.parseInt(val));
                queue.offer(root);
            }

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                String left = st.nextToken();
                String right = st.nextToken();
                if (!"null".equals(left)) {
                    TreeNode l = new TreeNode(Integer.parseInt(left));
                    queue.offer(l);
                    node.left = l;
                }
                if (!"null".equals(right)) {
                    TreeNode r = new TreeNode(Integer.parseInt(right));
                    queue.offer(r);
                    node.right = r;
                }
            }

            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);

        t5.left = t3;
        t5.right = t6;
        t3.left = t2;
        t3.right = t4;
        t6.right = t7;

        Codec c = new Codec();
        String s = c.serialize(null);
        TreeNode d = c.deserialize(s);
        System.out.println();
    }
}
