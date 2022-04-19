//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法 
// 👍 829 👎 0


package leetcode.editor.cn;

//Java：合并K个排序链表
public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
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
    //两两合并-递归
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            return merge(lists, 0, lists.length - 1);

        }

        private ListNode merge(ListNode[] lists, int lo, int hi) {
            if (lo == hi) {
                return lists[lo];
            }
            int mid = lo + (hi - lo) / 2;
            ListNode l1 = merge(lists, lo, mid);
            ListNode l2 = merge(lists, mid + 1, hi);
            return merge2List(l1, l2);
        }

        private ListNode merge2List(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = merge2List(l1.next, l2);
                return l1;
            }
            l2.next = merge2List(l1, l2.next);
            return l2;
        }
    }

    //利用小根堆 利用PriorityQueue 小根堆进行优化
    /*class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
            for (ListNode listNode : lists) {
                if (listNode != null) {
                    pq.offer(listNode);
                }
            }

            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while (!pq.isEmpty()) {
                ListNode minNode = pq.poll();
                tail.next = minNode;
                tail = tail.next;
                if (minNode.next != null) {
                    pq.offer(minNode.next);
                }
            }
            return dummyHead.next;
        }
    }*/
//leetcode submit region end(Prohibit modification and deletion)

}
