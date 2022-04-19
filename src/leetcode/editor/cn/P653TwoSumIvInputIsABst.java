//给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
// 
//
// 示例 2： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1, 104]. 
// -104 <= Node.val <= 104 
// root 为二叉搜索树 
// -105 <= k <= 105 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 
// 👍 356 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：两数之和 IV - 输入 BST
public class P653TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new P653TwoSumIvInputIsABst().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        //在递归搜索过程中记录下相应的节点值（使用 Set 集合），如果在遍历某个节点 xx 时发现集合中存在 k - x.val，
        // 说明存在两个节点之和等于 kk，返回 True，若搜索完整棵树都没有则返回 False
        //
        Set<Integer> set = new HashSet<>();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            int b = k - root.val;
            if (set.contains(b)) {
                return true;
            }
            set.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
