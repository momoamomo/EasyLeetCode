 [正则匹配.png](https://pic.leetcode-cn.com/37c66c3a6b86bb333543448e0171e4c770f9eec142ca6b69d93446e6aa068377-%E6%AD%A3%E5%88%99%E5%8C%B9%E9%85%8D.png)
```java
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        if(p.length() != 0)   dp[0][1] = false;
        int i = 0, j = 0;
        //初始化dp数组行
        for(i = 1; i < p.length(); i++){
            if(p.charAt(i) == '*')  dp[0][i + 1] = dp[0][i - 1];
            else    dp[0][i + 1] = false;
        }
        //初始化dp数组列
        for(i = 0; i < s.length(); i++){
            dp[i + 1][0] = false;
        }
        //开始dp
        for(i = 0; i < s.length(); i++){
            for(j = 0; j < p.length(); j++){
                if(p.charAt(j) == '.')  dp[i + 1][j + 1] = dp[i][j];
                else if(p.charAt(j) == '*'){
                    if(p.charAt(j - 1) == '.') dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1];
                    else{
                        if(s.charAt(i) != p.charAt(j - 1))  dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        else    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }
                else{
                    if(p.charAt(j) == s.charAt(i))  dp[i + 1][j + 1] = dp[i][j];
                    else    dp[i + 1][j + 1] = false;
                }
            }
        }    
        return dp[s.length()][p.length()];
    }
}
```