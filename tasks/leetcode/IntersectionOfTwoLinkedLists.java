package tasks.leetcode;

public class IntersectionOfTwoLinkedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null) {
            if (a != null) {
                a = a.next;
                sizeA++;
            }
            if (b != null) {
                b = b.next;
                sizeB++;
            }
        }
        int diff;
        ListNode longest;
        ListNode smallest;
        if (sizeA > sizeB) {
            diff = (sizeA-sizeB);
            longest = headA;
            smallest = headB;
        } else {
            diff = (sizeB-sizeA);
            longest = headB;
            smallest = headA;
        }

        while (diff > 0) {
            longest = longest.next;
            diff--;
        }

        while (longest != smallest) {
            longest = longest.next;
            smallest = smallest.next;
        }
        return longest;
    }

}
