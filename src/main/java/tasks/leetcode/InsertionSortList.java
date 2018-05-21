package tasks.leetcode;

public class InsertionSortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode sortedRoot = new ListNode(-1);
        ListNode curr = head;
        ListNode next = null;
        ListNode sortedCurr = sortedRoot;

        while (curr != null) {
            next = curr.next;

            //find a place to put curr from sortedRoot;
            while (sortedCurr.next != null && sortedCurr.next.val < curr.val) {
                sortedCurr = sortedCurr.next;
            }

            //place curr after sortedCurr
            curr.next = sortedCurr.next;
            sortedCurr.next = curr;
            sortedCurr = sortedRoot;
            curr = next;
        }
        return sortedRoot.next;
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(5);
        ln.next = new ListNode(3);
        ln.next.next = new ListNode(1);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(2);
        insertionSortList(ln);
    }
}
