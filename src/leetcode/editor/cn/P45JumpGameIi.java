//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1409 👎 0


package leetcode.editor.cn;

//Java：跳跃游戏 II
public class P45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public int jump(int[] nums) {
            //贪心算法：到达最后位置的前一跳的最远位置，每一跳都是最长的，从后往前推
            int pos = nums.length - 1;
            int minstep = 0;
            while (pos > 0) {
                for (int i = 0; i < pos; i++) {
                    if (i + nums[i] >= pos){
                        pos = i;
                        minstep++;
                        break;
                    }
                }
            }
            return minstep;

        }
        */


        //解法二：正向找能到的最远位置
        public int jump(int[] nums) {
            int len = nums.length;
            int end = 0;
            int maxPos = 0;
            int step = 0;
            for (int i = 0; i < len - 1; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (i == end) {
                    end = maxPos;
                    step++;
                }
            }
            return step;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
