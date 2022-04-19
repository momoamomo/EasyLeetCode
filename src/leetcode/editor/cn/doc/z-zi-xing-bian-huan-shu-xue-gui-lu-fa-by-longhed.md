将字符串排成z字形，然后横向打印，可以发现要打印的字符索引位置存在一定规律，根据索引的规律直接横向打印即可。
数学规律：
直接遍历numRows，当前行标记为 r ，
1、当`r = 0` 时: 要打印的索引i的位置为 `i = i + 2 * (numRows - r - 1)`;
2、当`r = 最后一行` 时: 要打印的索引i的位置为 `i = i + 2 * r`;
3、当`r = 中间行` 时: 要打印的索引i的位置为 `i = i + 2 * (numRows - r - 1)`和`i = i + 2 * r`依次交替出现;
综上，直接遍历numRows，写出以上3种情况，直接打印即可（中间注意不要有索引越界）。
```Java
class Solution {
    public String convert(String s, int numRows) {
        if(s == null) {
            return null;
        }
        if(s == "") {
            return "";
        }
        if(numRows <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < numRows; r++) {
            int i = r;
            if(r == 0) {
                while(i < s.length()) {
                    sb.append(s.charAt(i));
                    i = i + 2 * (numRows - r - 1);
                }
                continue;
            }
            if(r == numRows - 1) {
                while(i < s.length()) {
                    sb.append(s.charAt(i));
                    i = i + 2 * r;
                }
                continue;
            }
            while(i < s.length()) {
                sb.append(s.charAt(i));
                i = i + 2 * (numRows - r - 1);
                if(i >= s.length()) {
                    break;
                }
                sb.append(s.charAt(i));
                i = i + 2 * r;
            }
        }
        return sb.toString();
    }
}
```

**复杂度分析**

- 时间复杂度：O(n)，其中 n == len(s)
- 空间复杂度：如果不考虑返回的字符串占用的空间，空间复杂度为O(1)