//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        int[] nums = {-3, -2, -5, 3, -4};
        int target = -1;
        int out = solution.threeSumClosest(nums, target);
        System.out.println(out);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int len = nums.length;
            Arrays.sort(nums);
            int result = nums[0] + nums[1] + nums[2];
            int smallDiff = Math.abs(result - target);
            for (int i = 0; i < len; i++) {
                int l = i + 1;
                int r = len - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    int diff = Math.abs(sum - target);
                    if (diff < smallDiff) {
                        smallDiff = diff;
                        result = sum;
                    }
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    }else {
                        return target;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
