
### ððððð æ¬¢åº¦ âäºä¸â å½éå³å¨è ï¼æ¨ªå¹åæèµ·æ¥ï¼ððððð
æ é¢ä¸å®è¦ééç®ç®ï¼å¤§å®¶äºä¸èä¸å®è¦å¼å¼å¿å¿å¦ ã¾(*â§â½â¦*)ï¾

ä¸å¨çæå¡é¢ã[23. åå¹¶Kä¸ªæåºé¾è¡¨](https://leetcode-cn.com/problems/merge-k-sorted-lists/)ãè¿ååå¨ç®ï¼ä»å¤©å°±æ¥ã21. åå¹¶ä¸¤ä¸ªæåºé¾è¡¨ã~~éå~~(**å¸¸è**)ååï¼æ®æ®ééèµ·ä¸ªåºæ®æ®ééæä¸ªå¡ç¶åæ®æ®ééåºé¨å»æ¾ä¸ªæ®æ®ééçé£ï¼èæãï¼äºä¸å¿«ä¹å <(ï¿£ï¸¶ï¿£)âGO!ï¼

å³äºãåå¹¶Kä¸ªæåºé¾è¡¨ãå¯ä»¥ç§»æ­¥æçé¢è§£[ã4 ç§æ¹æ³è¯¦è§£ï¼ð¤·ââï¸å¿é¡»ç§æï¼ã](https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/)å·ï¼

---

### åå¹¶ä¸¤ä¸ªæåºé¾è¡¨

**éå½è§£æ³**
ä»£ç è¯­ä¹å¤ªæç¡®äºï¼ä¸è§£é â â
``` Java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
```

**è¿­ä»£è§£æ³**
dummyå¤§æ³æå¤å¦ï¼ç¨äºä½ å°±ä¼ç¥é! â§ââ¦
``` Java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 == null? l2: l1;

        return dummyHead.next;
    }
}
```
è¿éæ¯é¾è¡¨çå°¾ææ³ï¼å¤´ææ³ä¸è¬ç¨å¨éè¦é¾è¡¨éåºçåºæ¯ï¼æ¯å¦ç¨è¿­ä»£æ³è§£å³ã[206. åè½¬é¾è¡¨](https://leetcode-cn.com/problems/reverse-linked-list/)ãã


---

é¤äºã[23. åå¹¶Kä¸ªæåºé¾è¡¨](https://leetcode-cn.com/problems/merge-k-sorted-lists/)ãä¼ç¨å°æ¬é¢ãåå¹¶ä¸¤ä¸ªæåºé¾è¡¨ãçç¥è¯ç¹ä¹å¤ï¼å¯¹é¾è¡¨è¿è¡å½å¹¶æåºæ¶ merge çé¨åä¹ä¼ç¨å°æ¬é¢ç¥è¯ç¹å¦ï¼ä¾å¦ã[148. æåºé¾è¡¨](https://leetcode-cn.com/problems/sort-list/)ãã

---

å¤§ä½¬ä»¬éæã[å³æ³¨æ](https://leetcode-cn.com/u/sweetiee/)ãåï½


