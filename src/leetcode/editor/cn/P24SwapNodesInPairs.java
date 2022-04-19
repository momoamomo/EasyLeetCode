//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 579 👎 0


package leetcode.editor.cn;

//Java：两两交换链表中的节点
public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            //交换两个结点node1,node2时需要前后节点front,rear 辅助
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode front = dummyHead;
            while (front.next != null && front.next.next != null) {
                ListNode node1 = front.next;
                ListNode node2 = node1.next;
                ListNode rear = node2.next;
                node2.next = node1;
                node1.next = rear;
                front.next = node2;
                front= node1;
            }
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
