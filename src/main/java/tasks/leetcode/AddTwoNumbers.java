package tasks.leetcode;

public class AddTwoNumbers {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ListNode listNode = (ListNode) o;

            if (val != listNode.val) return false;
            return next != null ? next.equals(listNode.next) : listNode.next == null;
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }

    public static ListNode sum(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode root = result;
        boolean extra = false;
        while (l1 != null && l2 != null) {
            result.next = new ListNode(l1.val + l2.val + (extra ? 1 : 0));
            extra = false;
            if (result.next.val >= 10) {
                result.next.val = result.next.val - 10;
                extra = true;
            }
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l = l1 != null ? l1 : l2;
        while (l != null) {
            result.next = new ListNode(l.val + (extra ? 1 : 0));
            extra = false;
            if (result.next.val >= 10) {
                result.next.val = result.next.val - 10;
                extra = true;
            }
            result = result.next;
            l = l.next;
        }
        if (extra) {
            result.next = new ListNode(1);
        }
        return root.next;
    }

}
