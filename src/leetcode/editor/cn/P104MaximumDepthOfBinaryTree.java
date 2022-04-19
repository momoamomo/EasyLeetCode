//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 701 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.TreeNode;

//Java：二叉树的最大深度
public class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            //方法一：递归
            //先考虑边界条件，容错
            //树的最大深度等于当前节点深度 1 加左右子树最大深度
            if (root == null) {
                return 0;
            } else {
                int leftDepth = maxDepth(root.left);
                int rightDepth = maxDepth(root.right);
                return Math.max(leftDepth, rightDepth) + 1;
            }
            //方法二：遍历
            /*int maxDepth = 0;
            if(root ==null){
                return maxDepth;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            Queue<Integer> queue1 = new LinkedList<Integer>();
            queue.offer(root);
            queue1.offer(1);
            TreeNode p;
            while (queue.peek()!=null){
                p=queue.poll();
                int depth = queue1.poll();
                if(maxDepth<depth){
                    maxDepth =depth;
                }
                if(p.left!=null){
                    queue.offer(p.left);
                    queue1.offer(depth+1);
                }
                if(p.right!=null){
                    queue.offer(p.right);
                    queue1.offer(depth+1);
                }
            }
            return maxDepth;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
