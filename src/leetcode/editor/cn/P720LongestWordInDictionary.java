//给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。 
//
// 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
// 
//
// 示例 2： 
//
// 
//输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply" 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 30 
// 所有输入的字符串 words[i] 都只包含小写字母。 
// 
// Related Topics 字典树 数组 哈希表 字符串 排序 
// 👍 295 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Java：词典中最长的单词
public class P720LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new P720LongestWordInDictionary().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {
            //利用辅助集合思想 + 数据预处理（按要求排序：长度短->长，字典序大->小）
            Arrays.sort(words, (a, b) -> {
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                } else {
                    return b.compareTo(a);
                }
            });
            String str = "";
            Set<String> pool = new HashSet<String>(words.length);
            pool.add(str);
            for (int i = 0; i < words.length; i++) {
                if (pool.contains(words[i].substring(0, words[i].length() - 1))) {
                    pool.add(words[i]);
                    str = words[i];
                }
            }
            return str;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
