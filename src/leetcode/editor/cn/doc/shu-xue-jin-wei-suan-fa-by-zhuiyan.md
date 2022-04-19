```
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int sum = 0;
        int n = digits.length;
        int add = 1;
        digits[n-1] = digits[n-1] + add;
        for(int i=n-1;i>=0;i--){
            sum = digits[i] + carry;
            carry = sum / 10;
            digits[i]=sum%10;
        }
        if(digits[0]==0){
            int[] newdigits = new int[n + 1];
            newdigits[0] = carry;
            System.arraycopy(digits, 0, newdigits, 1, n);
            return newdigits;
        }
        return digits;
    }
}
```
其中add可以是任何数，加1，加2