//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 915 👎 0


package leetcode.editor.cn;

import java.util.Scanner;

//Java：删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        Scanner scanner = new Scanner(System.in);
        ListNode L = new ListNode(scanner.nextInt());
        System.out.println(L.val);

        /*ListNode L1 = new ListNode(1);
        ListNode L2 = new ListNode(2);
        ListNode L3 = new ListNode(3);
        ListNode L4 = new ListNode(4);
        ListNode L5 = new ListNode(5);*//*
        L1.next=L2;
        L2.next=L3;
        L3.next=L4;
        L4.next=L5;*/
        /*int n = 3;
        ListNode out = solution.removeNthFromEnd(L1, n);
        while (out.next != null){
            System.out.println(out.val);
            out= out.next;
        }
        System.out.println(out.val);*/

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode start = pre, end = pre;
            while (n != 0) {
                start = start.next;
                n--;
            }
            while (start.next != null) {
                start = start.next;
                end = end.next;
            }
            end.next = end.next.next;
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
