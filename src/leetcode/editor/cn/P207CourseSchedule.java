//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 1131 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：课程表
public class P207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
        int numCourses = 3;
        int[][] prerequisites = {{1, 0}, {2, 1}};
        boolean result = solution.canFinish(numCourses, prerequisites);
        System.out.println(result);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //记录每门课程的入度
            int[] indegree = new int[numCourses];
            int[][] matrix = new int[numCourses][numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                int curr = prerequisites[i][0];
                int pre = prerequisites[i][1];
                if (matrix[pre][curr] == 0) {
                    indegree[curr]++;
                }
                matrix[pre][curr] = 1;
            }

            int count = 0;
            Queue<Integer> queue = new LinkedList();
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            //没有入度为0的，说明都有依赖源，不能完成
            while (!queue.isEmpty()) {
                int course = queue.poll();
                count++;
                for (int i = 0; i < numCourses; i++) {
                    if (matrix[course][i] != 0) {// 节点 i 与该节点相连
                        indegree[i]--; // 与刚出队的节点相连的节点，入度减一
                        if (indegree[i] == 0) { // 如果为0，说明没有前驱，可以访问
                            queue.offer(i);
                        }
                    }
                }
            }
            return count == numCourses; // 如果所有节点是否都访问了，如果是说明成功
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
