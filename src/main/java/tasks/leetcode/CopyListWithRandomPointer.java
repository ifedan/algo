package tasks.leetcode;

public class CopyListWithRandomPointer {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode random;
        ListNode(int x) { val = x; }
    }

    public static ListNode copy(ListNode head) {
        ListNode node = head;
        ListNode copyHead = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = new ListNode(node.val);
            node.next.next = next;
            node = node.next.next;
        }
        copyHead = head.next;

        node = head;
        while (node != null) {
            node.next.random = node.random.next;
            node = node.next.next;
        }

        node = head;
        while (node != null) {
            ListNode next = node.next.next;
            if (next != null) {
                node.next.next = next.next;
            } else {
                node.next.next = null;
            }
            node = next;
        }

        return copyHead;
    }

}
