package tasks.leetcode;

public class RemoveDuplicatesFromSortedListII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        ListNode newHead = new ListNode(-1);
        ListNode root = newHead;
        while (node != null) {
            ListNode curr = node;
            boolean hasDuplicates = false;
            while (node.next != null && curr.val == node.next.val) {
                node = node.next;
                hasDuplicates = true;
            }

            if (!hasDuplicates) {
                root.next = node;
                node = node.next;
                root.next.next = null;
                root = root.next;
            } else {
                node = node.next;
            }
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode l1= new ListNode(1);
        ListNode l2= new ListNode(2);
        l1.next = l2;
        ListNode l3= new ListNode(3);
        l2.next = l3;
        ListNode l4= new ListNode(3);
        l3.next = l4;
        ListNode l5= new ListNode(4);
        l4.next = l5;
        ListNode l6= new ListNode(4);
        l5.next = l6;
        ListNode l7= new ListNode(5);
        l6.next = l7;

        deleteDuplicates(l1);
    }

}
