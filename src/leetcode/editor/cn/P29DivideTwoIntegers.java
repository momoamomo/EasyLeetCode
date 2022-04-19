//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 394 👎 0


package leetcode.editor.cn;

//Java：两数相除
public class P29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P29DivideTwoIntegers().new Solution();
        int dividend = 2147483647;
//        int dividend = -5;
        int divisor = 2;
        int out = solution.divide(dividend, divisor);
        System.out.println(out);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //方法一：时间复杂度O(n),超时
    /*class Solution {
        public int divide(int dividend, int divisor) {
            //除数不能为0
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            //同号标志位,不能用相乘结果是否>0判断是否同号，容易溢出
            boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
            int result = 0;
            //都转为负数来进行，因为−231的绝对值为231，超出整数的最大值231-1
            dividend = -Math.abs(dividend);
            divisor = -Math.abs(divisor);
            while (dividend <= divisor) {
                dividend -= divisor;
                result += 1;
            }
            return k ? result : -result;
        }
    }*/
    //方法二：二分法
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
            int result = 0;
            //都转为负数来进行，因为−231的绝对值为231，超出整数的最大值231-1
            dividend = -Math.abs(dividend);
            divisor = -Math.abs(divisor);
            while (dividend <= divisor) {
                int temp = divisor;
                int c = 1;
                while (dividend - temp <= temp) {
                    temp = temp << 1;
                    c = c << 1;
                }
                dividend -= temp;
                result += c;
            }
            return k ? result : -result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
