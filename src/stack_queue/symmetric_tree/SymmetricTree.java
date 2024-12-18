//package stack_queue.symmetric_tree;
//
//public class SymmetricTree {
//
//    /**
//     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
//     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
//     * this.left = left; this.right = right; } }
//     */
//
//    // 양쪽이 거울 형태
//    // 왼쪽에서 시작했을 때의 어레이
//    // 오른쪽에서 시작했을 때의 어레이
//    // 비교?
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        return isMirror(root.left, root.right);
//    }
//
//    private boolean isMirror(TreeNode left, TreeNode right) {
//        if (left == null && right == null) {
//            return true;
//        }
//        if (left == null || right == null) {
//            return false;
//        }
//
//        return (left.val == right.val &&
//                isMirror(left.left, right.right) &&
//                isMirror(left.right, right.left));
//    }
//
//}