### 1，递归
通过观察我们可以发现，生成的任何括号组合中都有两个规律：
- 1，括号组合中左括号的数量等于右括号的数量
- 2，括号组合中任何位置左括号的数量都是大于等于右括号的数量
第一条很容易理解，我们来看第二条，比如有效括号"(())()"，在任何一个位置右括号的数量都不大于左括号的数量，所以他是有效的。如果像这样"())()"第3个位置的是右括号，那么他前面只有一个左括号，而他和他前面的右括号有2个，所以无论如何都不能组合成有效的括号。搞懂了上面的原理，我们就以n等于2为例来画个图看一下
 [image.png](https://pic.leetcode-cn.com/7454e27ce54e75a32e809701eb71ae5311bf5c39dcd036bdb8f8040be8ac02e5-image.png)

```
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }

    private void dfs(List<String> res, int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，说明找到了有效的括号
            res.add(curStr);
            return;
        }
        //左括号只有剩余的时候才可以选，如果左括号的数量已经选完了，是不能再选左括号了。
        //如果选完了左括号我们是还可以选择右括号的。
        if (left < 0)
            return;
        // 如果右括号剩余数量小于左括号剩余的数量，说明之前选择的无效
        if (right < left)
            return;
        //选择左括号
        dfs(res, left - 1, right, curStr + "(");
        //选择右括号
        dfs(res, left, right - 1, curStr + ")");
    }
```
运行结果
 [image.png](https://pic.leetcode-cn.com/db5041a623e4dae336e1f9886fe89adf786c7e4b0cc15cf28fb906793fb63074-image.png)

### 2，动态规划
我们用dp[i]表示的是n等于i的时候生成的有效括号组合，那么递推公式就是
```
dp[i]="("+dp[m]+")"+dp[k]
其中m+k=i-1
```
因为他再加上我们添加的一对括号正好是i，（其中m是从0到i-1）所以这里我们需要枚举m的所有值。主要代码如下
```
for (int m = 0; m < i; m++) {
    int k = i - 1 - m;
    List<String> str1 = dp[m];
    List<String> str2 = dp[k];
    for (String s1 : str1) {
        for (String s2 : str2) {
            cur.add("(" + s1 + ")" + s2);
        }
    }
}
```
这题的边界条件是dp[0]=""，因为0的时候是没有括号的。所以完整代码如下
```
    public static List<String> generateParenthesis(int n) {
        List<String>[] dp = new List[n + 1];
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp[0] = dp0;
        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int m = 0; m < i; m++) {
                int k = i - 1 - m;
                List<String> str1 = dp[m];
                List<String> str2 = dp[k];
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp[i] = cur;
        }
        return dp[n];
    }
```
### 3，把上面的动态规划改递归
我们看到上面动态规划中核心代码是dp[m]和dp[k]的组合，而dp[m]和dp[k]分别表示的是n等于m和k的时候有效括号的组合，所以如果函数

List<String> generateParenthesis(int n)

表示的是n对有效括号的组合，那么

List<String> generateParenthesis(int m)

和

List<String> generateParenthesis(int k)

分别表示的是m对和k对有效括号的组合，所以上面的核心代码我们可以这样改

```
for (int m = 0; m < n; m++) {
    int k = n - m - 1;
    List<String> first = generateParenthesis(m);
    List<String> second = generateParenthesis(k);
    for (String left : first) {
        for (String right : second) {
            list.add("(" + left + ")" + right);
        }
    }
}
```
所以完整代码如下
```
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {//边界条件的判断
            list.add("");
            return list;
        }
        for (int m = 0; m < n; m++) {
            int k = n - m - 1;
            List<String> first = generateParenthesis(m);
            List<String> second = generateParenthesis(k);
            for (String left : first) {
                for (String right : second) {
                    list.add("(" + left + ")" + right);
                }
            }
        }
        return list;
    }
```

#### [393，括号生成](https://mp.weixin.qq.com/s/Ikwz2HQy3IWNe56GUFws4A)
#### 查看更多答案，可扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20190515124616751.jpg)**”