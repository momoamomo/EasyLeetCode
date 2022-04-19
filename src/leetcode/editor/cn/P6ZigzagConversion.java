//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串


package leetcode.editor.cn;

//Java：Z 字形变换
public class P6ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new P6ZigzagConversion().new Solution();
        String s = "LEETCODEISHIRING";
        String out = solution.convert(s, 4);
        System.out.println(out);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    //方法一：总结数学规律
    /*class Solution {
        public String convert(String s, int numRows) {
            //边界、容错处理
            if (s == null) {
                return null;
            }
            if (s == "") {
                return "";
            }
            if (numRows <= 1) {
                return s;
            }
            StringBuffer ss = new StringBuffer();
            for (int r = 0; r < numRows; r++) {
                int i = r;
                if (r == 0) {
                    while (i < s.length()) {
                        ss.append(s.charAt(i));
                        i = i + 2 * (numRows - r - 1);
                    }
                }
                if(r==numRows-1){
                    while (i<s.length()){
                        ss.append(s.charAt(i));
                        i = i+2*r;
                    }
                }
                while (i<s.length()){
                    ss.append(s.charAt(i));
                    i = i + 2 * (numRows - r - 1);
                    if(i>=s.length()){
                        break;
                    }
                    ss.append(s.charAt(i));
                    i = i+2*r;
                }
            }
            return ss.toString();
        }
    }*/
    //
    class Solution {
        public String convert(String s, int numRows) {
            if (s == null) {
                return null;
            }
            if (s == "") {
                return "";
            }
            if (numRows <= 1) {
                return s;
            }
            int r = 0;
            int falg = 1;
            StringBuffer[] ss = new StringBuffer[numRows];
            for (int j = 0; j <numRows ; j++) {
                ss[j] = new StringBuffer();
            }
            for (int i = 0; i < s.length(); i++) {
                ss[r].append(s.charAt(i));
                r += falg;
                if (r == 0) {
                    falg = 1;
                }
                if (r == numRows - 1) {
                    falg = -1;
                }
            }
            StringBuffer out = new StringBuffer();
            for (int i = 0; i < numRows; i++) {
                out.append(ss[i]);
            }
            return out.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
