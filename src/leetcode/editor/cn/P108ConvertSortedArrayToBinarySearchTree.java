//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 628 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.TreeNode;

//Java：将有序数组转换为二叉搜索树
public class P108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();
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
        public TreeNode sortedArrayToBST(int[] nums) {
            //先容错
            int num = nums.length;
            if (num == 0) {
                return null;
            }
            //使用递归
            return convertTree(nums, 0, nums.length - 1);
        }


        /**
         * 数组转化为平衡二叉树
         *
         * @param nums 数组
         * @param l 数组左边界
         * @param r 数组右边界
         * @return
         */
        private TreeNode convertTree(int[] nums, int l, int r) {
            if (l <= r) {
                int mid = (l + r) / 2;
                TreeNode node = new TreeNode(nums[mid]);
                node.left = convertTree(nums, l, mid - 1);
                node.right = convertTree(nums, mid + 1, r);
                return node;
            } else {
                return null;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
