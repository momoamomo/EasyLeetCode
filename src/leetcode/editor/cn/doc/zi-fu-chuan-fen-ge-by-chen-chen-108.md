### 解题思路
可以根据String的split()方法，快速将字符串进行分割为一个字符串数组,求解数组最后一个元素的长度即可

### 代码

```java
class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        String[] str = s.split(" ");
        int len = str.length;
        if(len == 0){
            return 0;
        }
        return str[len - 1].length();
    }
}
```