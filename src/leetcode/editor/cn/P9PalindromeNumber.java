//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


package leetcode.editor.cn;

//Java：回文数
public class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        int x = 10;
        boolean out = solution.isPalindrome(x);
        System.out.println(out);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            StringBuffer buffer = new StringBuffer();
            while (x > 0) {
                buffer.append(x % 10);
                x = x / 10;
            }
            int len = buffer.length();
            for (int i = 0; i < buffer.length() / 2; i++) {
                if (buffer.charAt(i) != buffer.charAt(len - 1 - i)) {
                    return false;
                }
            }
            return true;
            //方法二：int转string
//            String ss = x+"";
//            String ss =Integer.toString(x);
//            String ss =String.valueOf(x);

//            String reverss = new StringBuffer(x+"").reverse().toString();
//            return (x+"").equals(reverss);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
