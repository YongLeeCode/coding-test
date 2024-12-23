package exam3;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.tree.TreeNode;
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root.val);
        int depth = 1;

        while(!queue.isEmpty()) {
              queue.poll();
              if(queue == null){
                  continue;
              }
              queue.offer(root.left);
              queue.offer(root.right);
        }

        return depth;
    }

}
