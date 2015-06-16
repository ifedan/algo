package algos.structure;

import java.util.*;

/**
 * User: ifedan
 * Date: 4/22/15
 */
public class BST {

    private static class Node {
        Node left;
        Node right;
        int value;

        Node(int val) {
            this.value = val;
        }
    }

    private Node root;

    public void insert(int val) {
        if(root == null) {
            root = new Node(val);
            return;
        }
        Node root = this.root;
        while (root != null) {
            if (root.value == val) {
                return;
            } else if (root.value > val) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = new Node(val);
                }
            } else {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = new Node(val);
                }
            }
        }
    }

    public boolean contains(int val) {
        if (root == null) {
            return false;
        }
        Node root = this.root;
        while (root != null) {
            if (root.value == val) {
                return true;
            } else if (root.value > val) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    return false;
                }
            } else {
                if (root.right != null) {
                    root = root.right;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void depthFirst() {
        if (this.root == null) {
            return;
        }
        java.util.Stack stack = new java.util.Stack();
        Node root = this.root;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            Node node = (Node)stack.pop();
            System.out.println(node.value);
            if (node.right != null) {
                root = node.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }

        }
    }

    public void breadthFirst() {
        if (this.root == null) {
            return;
        }
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(this.root);
        Set<Integer> visited = new HashSet<Integer>();
        while(!list.isEmpty()) {
            Node node = list.removeFirst();
            System.out.println(node.value);
            visited.add(node.value);
            if (node.left != null && !visited.contains(node.left)) {
                list.add(node.left);
            }
            if (node.right != null && !visited.contains(node.right)) {
                list.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(1);
        tree.insert(1);
        tree.insert(2);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(10);
        tree.insert(3);
        tree.insert(11);
        tree.depthFirst();
        System.out.println("----------------");
        tree.breadthFirst();
    }

}
