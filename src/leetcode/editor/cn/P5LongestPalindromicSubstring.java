//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

//Java：最长回文子串
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        String s = "babad";
        String out = solution.longestPalindrome(s);
        System.out.println(out);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    //方法一：暴力Time Limit Exceeded
/*class Solution {
    public String longestPalindrome(String s) {
        String result= "";
        int len = s.length();
        int maxplen = 0;
        for (int i = 0; i <len; i++) {
            for (int j = i+1; j <=len ; j++) {
                String sub = s.substring(i,j);
                if(isPalindrome(sub) && sub.length()>maxplen){
                    maxplen = sub.length();
                    result = sub;
                }
            }
        }
        return result;
    }

    //字符串str是否为回文
    public boolean isPalindrome(String str){
        int len = str.length();
        for (int i = 0; i <len/2 ; i++) {
            if(str.charAt(i) != str.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}
*/

//解法二：动态规划，P(i,j)表示i-j之间的字符串，如果p(i+1,j-1)是回文，而且i+1位置和j-1位置上的字符一致的话，p(i,j)也是回文

    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int len = s.length();
            int maxStrat = 0, maxEnd = 0;
            int maxLen = 1;
            boolean[][] dp = new boolean[len][len];
            //j表示右 ，i表示左
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if (s.charAt(j) == s.charAt(i) && (j - i <= 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            maxStrat = i;
                            maxEnd = j;
                        }
                    }
                }
            }
            return s.substring(maxStrat, maxEnd+1);

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
