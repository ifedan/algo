package tasks.leetcode;

public class LinkedListRandomNode {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    ListNode head;
    int size;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.size = size(head);
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int randIndex = (int)(Math.random() * size);
        return getByIndex(head, randIndex);
    }

    private int getByIndex(ListNode node, int i) {
        int count = 0;
        while (node != null && count < i) {
            node = node.next;
            count++;
        }
        return node.val;
    }

    private int size(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode test = new LinkedListRandomNode(head);
        test.getRandom();
    }
}
