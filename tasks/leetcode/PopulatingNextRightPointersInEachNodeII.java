package tasks.leetcode;

public class PopulatingNextRightPointersInEachNodeII {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
        public String toString() {
            return ""+val;
        }
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
                    newQueueHead = left != null ? left : right;
                }

                if (left != null) {
                    left.next = right;
                }

                if (newQueueTail != null) {
                    newQueueTail.next = left != null ? left : right;
                }

                if (right != null || left != null) {
                    newQueueTail = right != null ? right : left;
                }

                queue = queue.next;
            }
            queue = newQueueHead;
            newQueueHead = null;
            newQueueTail = null;
        }
    }

    public static void main(String[] args) {

        //{-9,-3,2,#,4,4,0,-6,#,-5}

        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);

        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        //root.right.left = new TreeLinkNode(4);
        root.right.right = new TreeLinkNode(6);

        root.left.left.left = new TreeLinkNode(7);
        root.right.right.right = new TreeLinkNode(8);

        connect(root);
    }

}
