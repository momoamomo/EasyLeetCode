//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 524 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：加一
public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        int[] digits = {4,3,2,1};
        int[] result = solution.plusOne(digits);
        System.out.println(Arrays.toString(result));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /*class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length-1; i >=0 ; i--) {
                digits[i]++;
                digits[i]= digits[i]%10;
                if(digits[i]!=0){
                    return digits;
                }
            }
            digits = new int [digits.length-1];
            digits[0]=1;
            return digits;
        }
    }*/

    class Solution{
        public int[] plusOne(int[] digits) {
            int carry = 0;
            int sum = 0;
            int n =digits.length;
            int add =1;
            digits[n-1]=digits[n-1]+add;
            for (int i = n-1; i >=0 ; i--) {
                sum = digits[i]+carry;
                carry= sum/10;
                digits[i]=sum%10;
            }
            if(digits[0]==0){
                int[] newdigits = new int[n+1];
                newdigits[0]=carry;
                System.arraycopy(digits,0,newdigits,1,n);
                return newdigits;
            }
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
