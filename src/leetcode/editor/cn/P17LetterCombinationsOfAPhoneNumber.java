//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 809 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        String digits = "234";
        List<String> out = solution.letterCombinations(digits);
        System.out.println(out);

        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private Map<Character, List<String>> map = new HashMap<>();
        private ArrayList<String> res = new ArrayList<String>();

        public List<String> letterCombinations(String digits) {
            map.put('2', Arrays.asList("a", "b", "c"));
            map.put('3', Arrays.asList("d", "e", "f"));
            map.put('4', Arrays.asList("g", "h", "i"));
            map.put('5', Arrays.asList("j", "k", "l"));
            map.put('6', Arrays.asList("m", "n", "o"));
            map.put('7', Arrays.asList("p", "q", "r", "s"));
            map.put('8', Arrays.asList("t", "u", "v"));
            map.put('9', Arrays.asList("w", "x", "y", "z"));

            //递归
            if (digits.equals("")) {
                return new ArrayList<String>();
            }
            findCom(digits, 0, "");
            return res;
        }

        private void findCom(String digits, int index, String s) {
            if (index == digits.length()) {
                res.add(s);
                return;
            }
            List<String> values = map.get(digits.charAt(index));
            for (int j = 0; j < values.size(); j++) {
                findCom(digits, index + 1, s + values.get(j));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
