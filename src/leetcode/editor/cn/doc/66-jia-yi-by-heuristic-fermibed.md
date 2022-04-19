### 解题思路
1. 根据题意 0为特殊值，单独操作，遇 0赋 1即可。
2. 在末位不为 9时，给末位数值 + 1即可。
3. 末位为 9时，需考虑进位，末位赋 0；前一位 + 1。
4. 若为 [9]、[9,9]、[9,9,9]... 则需让数组长度 + 1, 并给首位赋 1，其余位赋0；可新设一比原数组长度大一的数组，赋上新值，再将新数组赋给原数组。

### 代码

```java
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[0] == 0)
        {
            digits[0] = 1;
        }
        else
        {
            int k = digits.length;
            digits[k - 1] = digits[k - 1] + 1;
            for(int i = k - 1; i > 0; i--)
            {
                if(digits[i] == 10)
                {
                    digits[i] = 0;
                    digits[i - 1] = digits[i - 1] + 1;
                }
                else{
                    break;
                }
            }
            if(digits[0] == 10)
            {
                int[] tem = new int[k + 1];
                tem[0] = 1;
                tem[1] = 0;
                for(int j = 1; j < k; j++)
                {
                    tem[j + 1] = digits[j];
                }
                digits = tem;
            }
        }
        return digits;
    }
}
```