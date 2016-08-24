package tasks.leetcode;

public class PopulatingNextRightPointersInEachNode {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public static void connect(TreeLinkNode root) {
        TreeLinkNode queue = root;
        TreeLinkNode newQueueHead = null;
        TreeLinkNode newQueueTail = null;

        boolean flag = true;
        while (flag) {
            flag = false;
            while (queue != null) {
                TreeLinkNode left = queue.left;
                TreeLinkNode right = queue.right;
                flag = flag | (left != null) | (right!=null);
                if (newQueueHead == null) {
                    newQueueHead = left;
                }
                if (newQueueHead == null) {
                    newQueueHead = right;
                }
                if (left != null) {
                    left.next = right;
                }
                if (newQueueTail != null) {
                    newQueueTail.next = left != null ? left : right;
                }
                if (right != null) {
                    newQueueTail = right;
                }
                queue = queue.next;
            }
            queue = newQueueHead;
            newQueueHead = null;
            newQueueTail = null;
        }
    }
}
