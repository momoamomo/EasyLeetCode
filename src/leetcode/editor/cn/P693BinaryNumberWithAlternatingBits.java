//给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5
//输出：true
//解释：5 的二进制表示是：101
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：false
//解释：7 的二进制表示是：111. 
//
// 示例 3： 
//
// 
//输入：n = 11
//输出：false
//解释：11 的二进制表示是：1011. 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 178 👎 0


package leetcode.editor.cn;

//Java：交替位二进制数
public class P693BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        Solution solution = new P693BinaryNumberWithAlternatingBits().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution { 
        public boolean hasAlternatingBits(int n) {
            //解法一：字符串判断
            /*String bin = Integer.toBinaryString(n);
            if (bin.contains("00") || bin.contains("11")) {
                return false;
            }
            return true;*/

            //解法二：采用位运算(二进制交替出现的话，移动一位之后异或结果为末尾全1，全1加1后是全0, 进行与操作结果为0)
            n ^= (n >> 1);
            return (n & (n + 1)) == 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
