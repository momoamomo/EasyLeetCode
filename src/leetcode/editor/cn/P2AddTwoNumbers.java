//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


package leetcode.editor.cn;

//Java：两数相加
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode();
        l1.next = new ListNode();
        l1.next.next = new ListNode();
        ListNode l2 = new ListNode();
        l2.next = new ListNode();
        l2.next.next = new ListNode();
        l1.val = 2;
        l1.next.val=4;
        l1.next.next.val=3;
        l2.val =5;
        l2.next.val=6;
        l2.next.next.val=4;
        ListNode out = solution.addTwoNumbers(l1,l2);
        System.out.println(out.val+"->"+out.next.val+"->"+out.next.next.val);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            //进位
            int carry = 0;
            ListNode curr = dummy;

            while (l1 != null || l2 != null || carry > 0) {
                curr.next = new ListNode();
                curr = curr.next;
                if (l1 != null) {
                    carry += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    carry += l2.val;
                    l2 = l2.next;
                }
                curr.val = carry % 10;
                carry = carry / 10;
            }
            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
