//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1023 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.TreeNode;

//Java：对称二叉树
public class P101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new P101SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            //思路：
            //误区：不是左右子树相同，是左子树的左子树与右子树的右子树相同，且 左子树的右子树与右子树的左子树相等，对称
            //先进行容错处理
            if (root == null) {
                return true;
            }else {
                return compare(root.left, root.right);
            }
        }

        private boolean compare(TreeNode left, TreeNode right) {
            if (left == null) {
                return right==null;
            }
            if (right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return compare(left.left, right.right) && compare(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
