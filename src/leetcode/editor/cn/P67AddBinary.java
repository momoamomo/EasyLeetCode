//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 469 👎 0


package leetcode.editor.cn;

//Java：二进制求和
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        String out = solution.addBinary("1010","1011");
        System.out.println(out);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public String addBinary(String a, String b) {
            //先进行容错处理
            if (a == null || a.length() == 0) {
                return b;
            }
            if (b == null || b.length() == 0) {
                return a;
            }
            //用StringBuilder接收结果
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;

            int c = 0;
            while (i >= 0 || j >= 0) {
                if (i >= 0) {
                    c += a.charAt(i--) - '0';
                }
                if (j >= 0) {
                    c += b.charAt(j--) - '0';
                }
                sb.append(c % 2);
                c >>= 1;
            }
            String res = sb.reverse().toString();
            return c > 0 ? '1' + res : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
