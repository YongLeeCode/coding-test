//package exam3;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import javax.swing.tree.TreeNode;
//
//public class PathSum {
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode() {}
//     *     TreeNode(int val) { this.val = val; }
//     *     TreeNode(int val, TreeNode left, TreeNode right) {
//     *         this.val = val;
//     *         this.left = left;
//     *         this.right = right;
//     *     }
//     * }
//     */
//
//    // targetSum 찾기
//    // 노드 숫자: 0 ~ 5000
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if(root == null) {
//            return false;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<Integer> sum = new LinkedList<>();
//        queue.offer(root);
//        sum.offer(root.val);
//
//
//        while(!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            int curr_sum = sum.poll();
//
//            if(node.left == null && node.right == null && targetSum == curr_sum) {
//                return true;
//            }
//
//            if(node.left != null){
//                queue.offer(node.left);
//                sum.offer(node.left.val + curr_sum);
//            }
//            if(node.right != null){
//                queue.offer(node.right);
//                sum.offer(node.right.val + curr_sum);
//            }
//
//        }
//
//        return false;
//    }
//
//
//}
