//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


package leetcode.editor.cn;

//Java：最长公共前缀
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        String[] strs = {"c","c"};
        String out = solution.longestCommonPrefix(strs);
        System.out.println(out);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            /*int size= strs.length;
            if(size ==0){
                return "";
            }
            if(size==1) {
                return strs[0];
            }
            if(size>1){
                int len = strs[0].length();
                for (int i = 1; i < strs.length; i++) {
                    len = strs[i].length() < len ? strs[i].length() : len;
                }
                for (int i = 0; i <len; i++) {
                    for (int j = 1; j < strs.length; j++) {
                        if(strs[j].charAt(i)!=strs[0].charAt(i)){
                            return strs[0].substring(0,i);
                        }
                    }
                }
            }
            return "";
        }*/

        //他人方法：
            if(strs==null||strs.length==0){
                return "";
            }
            //把数组中第一个元素作为参照对比项
            //string的indexof函数返回其在该字符串中的位置，公共前缀indexof值为0
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(strs[0])!=0){
                    strs[0]= strs[0].substring(0,strs[0].length()-1);
                    if(strs[0].isEmpty()){
                        return "";
                    }

                }
            }
            return strs[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
