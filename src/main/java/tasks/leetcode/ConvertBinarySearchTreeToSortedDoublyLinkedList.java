package tasks.leetcode;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        bfs(root);
        head.right.left = prev;
        prev.right = head.right;
        return head.right;
    }

    Node head = new Node();
    Node prev = head;

    public void bfs(Node root) {
        if (root == null) return;
        bfs(root.left);

        root.left = prev;
        prev.right = root;
        prev = root;

        bfs(root.right);
    }
}
