package algos.graph;

import java.util.Stack;

public class BinaryTreeTraversal {

    static class Node {
        Node left;
        Node right;
        int val;
        Node(int val) {this.val = val;}
    }

    public static void preorder(Node node) {
        if (node == null) return;
        visit(node);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        visit(node);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        visit(node);
    }

    public static void preorderIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            visit(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inorderIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                visit(node);
                node = node.right;
            }
        }

    }

    public static void postorderIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        Node lastVisited = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                Node peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    node = peekNode.right;
                } else {
                    visit(peekNode);
                    lastVisited = stack.pop();
                }
            }
        }
    }

    private static void visit(Node node) {
        System.out.println(node.val);
    }

}
