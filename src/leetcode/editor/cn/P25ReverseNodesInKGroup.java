//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 669 👎 0


package leetcode.editor.cn;

//Java：K 个一组翻转链表
public class P25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode front = dummyHead;
            ListNode rear = dummyHead;
            while (rear.next != null) {
                for (int i = 0; i < k && rear != null; i++) {
                    rear = rear.next;
                }
                if (rear == null) {
                    break;
                }
                ListNode start = front.next;
                ListNode next = rear.next;
                rear.next = null;
                front.next = reverse(start);
                start.next = next;
                front = start;
                rear = front;
            }
            return dummyHead.next;
        }

        //一直把curr的next指向pre(滑动窗口)
        private ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
