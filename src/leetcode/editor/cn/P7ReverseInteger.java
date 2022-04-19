//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学


package leetcode.editor.cn;

//Java：整数反转
public class P7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        int x = 123;
        int out = solution.reverse(x);
        System.out.println(out);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int reverse(int x) {
            int target = 0;
            while ((x - x % 10) != 0) {
//                int max = Integer.MAX_VALUE/10;
//                int min = Integer.MIN_VALUE/10;
//                int ex = x % 10 + target;
                if (x % 10 + target > Integer.MAX_VALUE/10 || x % 10 + target < Integer.MIN_VALUE/10) {
                    return 0;
                }
                target = (x % 10 + target) * 10;
                x = (x - x % 10) / 10;

            }
            target = target + x;
            return target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
