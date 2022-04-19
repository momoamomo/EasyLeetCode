//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 694 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Java：杨辉三角
public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        System.out.println(solution.generate(5));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            //dp[i][j]=1 ,当j = 0 或 i=j
            //dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            List<List<Integer>> result = new ArrayList<>();
            Integer[][] dp = new Integer[numRows][numRows];
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }

                }
            }
            for (int i = 0; i < numRows; i++) {
                List<Integer> list = Arrays.asList(dp[i]).stream().filter(e -> e != null).collect(Collectors.toList());
                result.add(list);
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
