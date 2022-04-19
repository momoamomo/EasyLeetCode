//给定一个整数 n ，返回 n! 结果中尾随零的数量。 
//
// 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：0
//解释：3! = 6 ，不含尾随 0
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：1
//解释：5! = 120 ，有一个尾随 0
// 
//
// 示例 3： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 104 
// 
//
// 
//
// 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？ 
// Related Topics 数学 
// 👍 621 👎 0


package leetcode.editor.cn;

//Java：阶乘后的零
public class P172FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new P172FactorialTrailingZeroes().new Solution();
        int res = solution.trailingZeroes(30);
        System.out.println(res);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            if (n == 0) {
                return 0;
            }
            //全部分解因子之后，2和5的个数，最后零的个数为Math.min(2d的个数，5的个数)
            //5的个数肯定比2的个数少
            int num0 = 0;
            for (int i = 5; i <= n; i += 5) {
                for (int j = i; j % 5 == 0; j /= 5) {
                    num0++;
                }
            }
            return num0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
