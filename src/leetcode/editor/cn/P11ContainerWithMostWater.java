//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针


package leetcode.editor.cn;
//Java：盛最多水的容器
public class P11ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new P11ContainerWithMostWater().new Solution();
        int[] height = {1,1};
        int out = solution.maxArea(height);
        System.out.println(out);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    /*public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                int len = j-i;
                temp=height[i] >= height[j]? len*height[j]:len*height[i];
                if(temp>max){
                    max = temp;
                }
            }
        }
        return max;
    }*/


    //别人高效解法：双指针
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while (l<r){
            int temp = Math.min(height[l],height[r])*(r-l);
            max = Math.max(max,temp);
            if(height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
