//图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。 
//
// 每个单元格的 平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。 
//
// 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。 
//
// 
//
// 给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入:img = [[1,1,1],[1,0,1],[1,1,1]]
//输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
//解释:
//对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
//对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
//对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
// 
//
// 示例 2: 
//
// 
//输入: img = [[100,200,100],[200,50,200],[100,200,100]]
//输出: [[137,141,137],[141,138,141],[137,141,137]]
//解释:
//对于点 (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
//
//对于点 (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.
//666667) = 141
//对于点 (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) =
// 138
// 
//
// 
//
// 提示: 
//
// 
// m == img.length 
// n == img[i].length 
// 1 <= m, n <= 200 
// 0 <= img[i][j] <= 255 
// 
// Related Topics 数组 矩阵 
// 👍 143 👎 0


package leetcode.editor.cn;

//Java：图片平滑器
public class P661ImageSmoother {
    public static void main(String[] args) {
        Solution solution = new P661ImageSmoother().new Solution();
        int[][] img = {{100,200,100},{200,50,200},{100,200,100}};
        int[][] res= solution.imageSmoother(img);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+",");
            }
            System.out.println();

        }
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] imageSmoother(int[][] img) {
            int m = img.length;
            int n = img[0].length;
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //数量计数，和累计,符合正常数值就累加上
                    int num =0,sum=0;
                    for (int k = i-1; k <=i+1 ; k++) {
                        for (int l = j-1; l <=j+1 ; l++) {
                            if(k>=0&&k<m&&l>=0&&l<n){
                                num++;
                                sum += img[k][l];
                            }

                        }
                    }
                    res[i][j]=sum/num;

                    //暴力
                    /*//四个角
                    if (i == 0 && j == 0) {
                        res[i][j] = (img[i][j] + img[i + 1][j] + img[i][j + 1] + img[i + 1][j + 1]) / 4;
                        continue;
                    }
                    if (i == m - 1 && j == n - 1) {
                        res[i][j] = (img[i][j] + img[i - 1][j] + img[i][j - 1] + img[i - 1][j - 1]) / 4;
                        continue;
                    }
                    if (i == 0 && j == n - 1) {
                        res[i][j] = (img[i][j] + img[i + 1][j] + img[i][j - 1] + img[i + 1][j - 1]) / 4;
                        continue;
                    }
                    if (i == m - 1 && j == 0) {
                        res[i][j] = (img[i][j] + img[i - 1][j] + img[i][j + 1] + img[i - 1][j + 1]) / 4;
                        continue;
                    }
                    //四条边中间部分
                    if (i == 0 && j > 0 && j < n - 1) {
                        res[i][j]=(img[i][j]+img[i][j-1]+img[i][j+1]+img[i+1][j]+img[i+1][j-1]+img[i+1][j+1])/6;
                        continue;
                    }
                    if (i == m-1 && j > 0 && j < n - 1) {
                        res[i][j]=(img[i][j]+img[i][j-1]+img[i][j+1]+img[i-1][j]+img[i-1][j-1]+img[i-1][j+1])/6;
                        continue;
                    }
                    if (i > 0 && i < m - 1 && j == 0) {
                        res[i][j]=(img[i][j]+img[i-1][j]+img[i+1][j]+img[i][j+1]+img[i-1][j+1]+img[i+1][j+1])/6;
                        continue;
                    }
                    if (i > 0 && i < m - 1 && j == n-1) {
                        res[i][j]=(img[i][j]+img[i-1][j]+img[i+1][j]+img[i][j-1]+img[i-1][j-1]+img[i+1][j-1])/6;
                        continue;
                    }
                    //完全部分
                    res[i][j]=(img[i][j]+img[i-1][j-1]+img[i-1][j]+img[i-1][j+1]+img[i][j-1]+img[i][j+1]+img[i+1][j-1]+img[i+1][j]+img[i+1][j+1])/9;
               */

                }

            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
