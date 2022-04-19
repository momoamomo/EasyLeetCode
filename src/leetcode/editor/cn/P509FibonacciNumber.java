//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 
//
// 给定 N，计算 F(N)。 
//
// 
//
// 示例 1： 
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// 示例 2： 
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// 示例 3： 
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ N ≤ 30 
// 
// Related Topics 数组 
// 👍 176 👎 0


package leetcode.editor.cn;

//Java：斐波那契数
public class P509FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new P509FibonacciNumber().new Solution();
        int result = solution.fib(3);
        System.out.println(result);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /*//解法一：暴力破解
        public int fib1(int N) {
            if (N == 1 || N == 2) {
                return 1;
            }
            return fib1(N - 1) + fib1(N - 2);
        }

        //解法二：
        public int fib2(int N) {
            if (N < 1) {
                return 0;
            }
            int[] memo = new int[N + 1];
            return helper(memo, N);

        }

        private int helper(int[] memo, int n) {
            if (n == 1 || n == 2) {
                return 1;
            }
            //查看是否已经计算过
            if (memo[n] != 0) {
                return memo[n];
            }
            memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
            return memo[n];
        }

        //解法三：自底向上
        public int fib3(int N) {
            if (N < 1) {
                return 0;
            }
            if (N == 1 || N == 2) {
                return 1;
            }
            int[] dp = new int[N + 1];
            dp[1] = dp[2] = 1;
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[N];
        }*/

        //解法四：
        public int fib(int N) {
            if (N < 1) {
                return 0;
            }
            if (N == 1 || N == 2) {
                return 1;
            }
            int pre = 1, cuu = 1;
            for (int i = 3; i <= N; i++) {
                int sum = pre + cuu;
                pre = cuu;
                cuu = sum;
            }
            return cuu;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
