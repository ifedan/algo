package tasks.leetcode;

public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int size = 0;
        ListNode node = head;

        while (node != null) {
            node = node.next;
            size++;
        }
        k = k % size;

        int i = 0;
        node = head;
        while (i < k && node != null) {
            node = node.next;
            i++;
        }

        if (node == null) return head;

        ListNode pointer = head;
        while (node.next != null) {
            node = node.next;
            pointer = pointer.next;
        }
        node.next = head;
        head = pointer.next;
        pointer.next = null;

        return head;

    }


    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        //ListNode two = new ListNode(2);
        //ListNode three = new ListNode(3);
        //ListNode four = new ListNode(4);
        //ListNode five = new ListNode(5);

        //one.next = two;
        //two.next = three;
        //three.next = four;
        //four.next = five;

        rotateRight(one, 1);
    }

}
