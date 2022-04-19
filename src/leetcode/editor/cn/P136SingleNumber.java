//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 
// 👍 2263 👎 0


package leetcode.editor.cn;

//Java：只出现一次的数字
public class P136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new P136SingleNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            //任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕0=a。
            //任何数和其自身做异或运算，结果是 00，即 a⊕a=0。
            //异或运算满足交换律和结合律，即a⊕b⊕a=b⊕a⊕a=b⊕0=b
            int signal = 0;
            for (int num : nums) {
                signal ^= num;
            }
            return signal;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
