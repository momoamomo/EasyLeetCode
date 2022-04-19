//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


package leetcode.editor.cn;
//Java：寻找两个正序数组的中位数
public class P4MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2, 4 };
        double out = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(String.valueOf(out));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < all.length; k++) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    all[k] = nums1[i];
                    i++;
                } else {
                    all[k] = nums2[j];
                    j++;
                }
            } else if (i < nums1.length) {
                all[k] = nums1[i];
                i++;
            } else if (j < nums2.length) {
                all[k] = nums2[j];
                j++;
            }
        }
        int len = all.length;
        double result = 0;
        if (len % 2 == 0) {
            result = ((double) all[len / 2 - 1] + (double) all[len / 2]) / 2;
        } else {
            result = (double) all[len / 2 ];
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
