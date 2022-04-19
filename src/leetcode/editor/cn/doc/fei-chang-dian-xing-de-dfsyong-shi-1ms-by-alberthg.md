### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        if (n == 0) {
            return resultList;
        }
        dfs(n, n, "", resultList);
        return resultList;
    }


    /**
     * @param currLeft   剩下多少个“(”
     * @param currRight  剩下多少个“)”
     * @param currStr    当前记录字符串
     * @param resultList 结果合集
     **/
    private void dfs(int currLeft, int currRight, String currStr, List<String> resultList) {

        if (currLeft == 0) {
            if (currRight == 0) {
                resultList.add(currStr);
            } else {
                dfs(currLeft, currRight - 1, currStr + ")", resultList);
            }
        } else {
            dfs(currLeft - 1, currRight, currStr + "(", resultList);
            if (currRight > currLeft) {
                dfs(currLeft, currRight - 1, currStr + ")", resultList);
            }
        }
    }
}
```