package tasks.leetcode;

import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public static List<Integer> countSmaller(int[] nums) {
        BST tree = new BST();
        Integer res[] = new Integer[nums.length];
        for (int i = nums.length-1; i>= 0; i--) {
            res[i] = tree.insert(nums[i]);
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        //26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41
        System.out.println(countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));

    }

    static class BST {

        TreeNode root = null;
        final Holder h = new Holder();
        int insert(int val) {
            root = insert(root, val, 0, h);
            return h.val;
        }

        TreeNode insert(TreeNode root, int val, int less, Holder h) {
            if (root == null) {
                h.val = less;
                return new TreeNode(val);
            }
            root.size++;
            if (root.val > val) {
                root.left = insert(root.left, val, less, h);
            } else if (root.val < val) {
                root.right = insert(root.right, val, less + (root.size - (root.right != null ? root.right.size : 0) - 1), h);
            } else {
                h.val = less + (root.left != null ? root.left.size : 0);
            }
            return root;
        }
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        int size = 1;

        TreeNode(int v) {this.val = v;}
    }

    static class Holder {
        int val;
    }

}
