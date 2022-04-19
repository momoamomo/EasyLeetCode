//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 109 
// 
// Related Topics 字典树 
// 👍 393 👎 0


package leetcode.editor.cn;

//Java：字典序的第K小数字
public class P440KThSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        Solution solution = new P440KThSmallestInLexicographicalOrder().new Solution();
        solution.findKthNumber(13,3);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int n, int k) {
            //1是字典序的最小数
            int curr = 1;
            //如果k=1,就不进入下面的循环直接返回1，找到第k-1小的数；
            k--;
            while (k > 0) {
                int steps = getSteps(curr, n);
                //当前节点下的数不够，去下个相邻节点找，减去相应的节点数
                if (steps <= k) {
                    k -= steps;
                    curr++;
                } else {
                    curr = curr * 10;
                    k--;
                }
            }
            return curr;


        }

        //计算当前节点下有多少小于等于n的子节点
        public int getSteps(int curr, long n) {
            int steps = 0;
            long first = curr;
            long last = curr;
            while (first <= n) {
                steps += Math.min(last, n) - first + 1;
                first = first * 10;
                last = last * 10 + 9;
            }
            return steps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
