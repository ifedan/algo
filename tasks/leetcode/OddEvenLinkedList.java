package tasks.leetcode;

public class OddEvenLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = new ListNode(-1);
        ListNode oddHead = odd;
        ListNode even = new ListNode(-1);
        ListNode evenHead = even;

        int i = 1;
        while (head != null) {
            if (i % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            i++;
        }

        odd.next = evenHead.next;
        even.next = null;
        return oddHead.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        oddEvenList(root);

    }
}
