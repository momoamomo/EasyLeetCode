//假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。 
//
// 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。 
//
// 
//
// 示例 1: 
//
// 
//输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piat
//ti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//输出: ["Shogun"]
//解释: 他们唯一共同喜爱的餐厅是“Shogun”。
// 
//
// 示例 2: 
//
// 
//输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC",
// "Shogun", "Burger King"]
//输出: ["Shogun"]
//解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= list1.length, list2.length <= 1000 
// 1 <= list1[i].length, list2[i].length <= 30 
// list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。 
// list1 的所有字符串都是 唯一 的。 
// list2 中的所有字符串都是 唯一 的。 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 215 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：两个列表的最小索引总和
public class P599MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        Solution solution = new P599MinimumIndexSumOfTwoLists().new Solution();
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] res = solution.findRestaurant(list1,list2);
        System.out.println(res);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            String[] shrot = list1.length <= list2.length ? list1 : list2;
            List<String> set1 = Arrays.asList(list1);
            List<String> set2 = Arrays.asList(list2);
            List<String>  res = new ArrayList<>();
            int minIndexSum = Integer.MAX_VALUE;
            for (int i = 0; i < shrot.length; i++) {
                int indexSum=0;
                String item = shrot[i];
                if(set1.contains(item)&&set2.contains(item)){
                    indexSum = set1.indexOf(item)+set2.indexOf(item);
                    if(indexSum<minIndexSum){
                        res.clear();
                        res.add(item);
                        minIndexSum=indexSum;
                    }else if(indexSum==minIndexSum){
                        res.add(item);
                    }
                }


            }
            return res.toArray(new String[res.size()]);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
