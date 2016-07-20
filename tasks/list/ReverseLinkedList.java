package tasks.list;

public class ReverseLinkedList {

    static class Node {
        Node next;
    }

    public static Node solve(Node node) {
        if (node == null || node.next == null) return node;
        Node prev = null;
        Node curr = node;
        Node next = node.next;
        while (curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
