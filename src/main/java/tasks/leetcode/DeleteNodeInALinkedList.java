package tasks.leetcode;

public class DeleteNodeInALinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            prev.val = curr.val;
            if (curr.next == null) {
                prev.next = null;
                break;
            }
        }
    }

}
