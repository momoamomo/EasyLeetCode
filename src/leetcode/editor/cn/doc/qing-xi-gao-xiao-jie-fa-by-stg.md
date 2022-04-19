 [image.png](https://pic.leetcode-cn.com/c7984d3de78a0943953858d944082f351d4511cc1fb006adf78172cc92a005b2-image.png)

```
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode tail = head;
        for(int i = 0; i < k-1; i++) {
            tail = tail.next;
            if(tail == null) return head; // 当前 链表 不够 k 个元素，直接返回
        }
        ListNode next = tail.next;
        reverse(head, tail);
        head.next = reverseKGroup(next, k);
        return tail;
    }
    //  head -> {1} -> {2} -> {3} -> tail  ===>>  tail -> {3} -> {2} -> {1} -> head
    ListNode reverse(ListNode head, ListNode tail) {
        if(tail != null && head.next == tail) {
            tail.next = head;
            return tail;
        }
        ListNode l = head, m = l.next, r = m.next;
        m.next = l;
        while(r != null && m != tail) {
            l = m;
            m = r;
            r = r.next;
            m.next = l;
        }
        return tail;
    }
}
```