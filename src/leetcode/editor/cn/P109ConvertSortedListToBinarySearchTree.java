//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 403 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.TreeNode;
import leetcode.editor.cn.ListNode;

//Java：有序链表转换二叉搜索树
public class P109ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P109ConvertSortedListToBinarySearchTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
        public TreeNode sortedListToBST(ListNode head) {
            //1.容错
            if (head == null) {
                return null;
            } else if (head.next == null) {
                return new TreeNode(head.val);
            }
            //2.关键：找中点 链表用快慢指针
            //前指针走一步，后指针走两步
            ListNode pre = head;
            ListNode slow = head.next;
            ListNode fast = head.next.next;
            while (fast != null && fast.next != null) {
                pre = pre.next;
                fast = fast.next.next;
                slow = slow.next;
            }
            pre.next = null;
            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(slow.next);
            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
