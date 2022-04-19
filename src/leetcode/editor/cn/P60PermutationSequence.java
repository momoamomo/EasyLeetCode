//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 递归 数学 
// 👍 619 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：排列序列
public class P60PermutationSequence{
    public static void main(String[] args) {
        Solution solution = new P60PermutationSequence().new Solution();
        System.out.println(solution.getPermutation(4,9));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //记录数字是否使用过
        private boolean[] used;
        //阶乘数组
        private int[] factorial;
        private int n;
        private int k;

        public String getPermutation(int n, int k) {
            this.n = n;
            this.k = k;
            //1. 查找全排列需要的布尔数组
            used = new boolean[n + 1];
            Arrays.fill(used, false);
            //2.记录阶乘数组
            calculateFactorial(n);
            StringBuilder path = new StringBuilder();
            dfs(0, path);
            return path.toString();
        }

        private void dfs(int index, StringBuilder path) {
            if (index ==n){
                return;
            }
            int cnt = factorial[n - 1 - index];
            for (int i = 1; i <= n; i++) {
                if (used[i]) {
                    continue;
                }
                if (cnt < k) {
                    k = k - cnt;
                    continue;
                }
                path.append(i);
                used[i] = true;
                dfs(index + 1, path);
                return;
            }
        }


        //计算n的阶乘值
        private void calculateFactorial(int n) {
            factorial = new int[n + 1];
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
