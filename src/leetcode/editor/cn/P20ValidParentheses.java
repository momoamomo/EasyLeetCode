//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1735 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Java：有效的括号

public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        String s = "([)]";
        Boolean out = solution.isValid(s);
        System.out.println(out);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isValid(String s) {
            Map<Character,Character> map= new HashMap<>();
            map.put('(',')');
            map.put('{','}');
            map.put('[',']');
            if(s.isEmpty()){
                return true;
            }
            Stack stack = new Stack();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(!stack.empty()){
                    char peek = (char) stack.peek();
                    if(!map.keySet().contains(peek)){
                        return false;
                    }
                    if (map.get(peek) == c) {
                        stack.pop();
                    }else {
                        stack.push(c);
                    }
                }else {
                    stack.push(c);
                }
            }
            return stack.empty()? true:false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
