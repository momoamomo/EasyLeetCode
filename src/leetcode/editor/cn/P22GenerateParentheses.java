//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1209 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        int n = 2;
        List<String> out = solution.generateParenthesis(n);
        System.out.println(out);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            if (n == 0) {
                return result;
            }
            dfs(n, n, "", result);
            return result;
        }

        private void dfs(int left, int right, String str, List<String> result) {
            if (left == 0 && right == 0) {
                result.add(str);
                return;
            }
            if (left < 0) {
                return;
            }
            if (left > right) {
                return;
            }
            dfs(left - 1, right, str + "(", result);
            dfs(left, right - 1, str + ")", result);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
