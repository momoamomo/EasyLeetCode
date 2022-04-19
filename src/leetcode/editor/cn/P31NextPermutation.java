//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 600 👎 0


package leetcode.editor.cn;
//Java：下一个排列

public class P31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        int[] nums = {1,3,2};
        solution.nextPermutation(nums);
        System.out.println(nums.toString());
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2, j = n - 1;
            while (i > 0 && nums[i] >= nums[i + 1]) {
                --i;
            }
            if (i >= 0) {
                while (nums[j] <= nums[i]){
                    --j;
                }
                swap(nums[i],nums[j]);
            }
            reverse(nums,i);
        }
         private void swap(int i,int j){
            int temp = i;
            i = j;
            j = temp;
         }

         private void reverse(int[] nums, int index){
             int i = index;
             int j = nums.length - 1;
             while(i < j) {
                 swap(nums[i], nums[j]);
                 i++;
                 j--;
             }

         }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
