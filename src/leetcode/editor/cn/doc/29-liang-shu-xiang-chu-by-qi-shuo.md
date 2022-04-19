### 解题思路
想了很长时间才想到的，真的是太笨了,
根据题意不能使用乘法，除法和mod，那么只能使用加法和减法，因为是两个数相除，想到的是只能是减法
比如 dividend=10，divisor=3 那么10=3+3+3+1；所以最后的结果是3，计算过程是10-3>3然后继续减7-3>3 然后继续 4-3>3 然后1<3所以商是3余数是1，根据题意只要返回商即可。
用diff记录减的结果
这道题就是用一次递减下去，直到diff<divisor结束，然后减过几次最终结果就是几。
当然这道题如果直接减肯定超时，所以需要进行优化比如 10 和3,因为10>3×2^0，10>3×2^1，10<3×2^2=12 
所以3×2^1=6<10<3×2^2=12  所以可以得到结果就是10-6=4>3  10/6=1 6=3×2 所以结果是2+1=3；
其实就是如果依次减divisor肯定超时，所以成倍的减divisor就会得到极大的优化。

### 代码

```java
class Solution {
    public  int divide(int dividend, int divisor) {
        //判断符号
        int symbol=((long)dividend > 0 && (long)divisor > 0)|| ((long)dividend < 0 && (long)divisor < 0)?1:-1;
        //如果|dividend|<|divisor|那么结果肯定是0
        if (Math.abs((long)dividend) < Math.abs((long)divisor)) {
            return 0;
        //如果相等那就返回对应的符号
        } else if (Math.abs((long)dividend) == Math.abs((long)divisor)) {
            return symbol;
        }
        //divisor==1直接返回dividend
        if(divisor==1){
            return dividend;
        }
        //divisor==-1时候需要注意边界条件，java中dividend==-2^31那么他的绝对值还是它本身
        if(divisor==-1){
            //如果绝对值还是自己本身说明dividend==-2^31已经超过int边界直接返回int的最大值也就是2^31-1
            if(Math.abs(dividend)==dividend && Integer.MAX_VALUE!=dividend){
                return Integer.MAX_VALUE;
            }else{
                return symbol*(Math.abs(dividend)/1);
            }
        }
        //用于记录divisor乘以几倍
        int count = 0;
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        long temp = b;
        //当a<temp时候说明b*Math.pow(2, count )>a;
        while (a > temp) {
            //<<相当于temp*2
            temp = temp << 1;
            count++;
        }
        //计算差值，因为temp>a并且temp/2==temp>>1<a,计算两者的差
        long diff = a - (temp >> 1);
        //计算结果
        double result = Math.pow(2, count - 1);
        //从diff开始依次减b
        while (diff >= b) {
            diff = diff - b;
            result++;
        }
        //最终返回结果
        return symbol>0?(int) result:-(int) result;
    }
}
```
上面的可以通过所有测试用例，但是耗时是1804ms，但是可以优化，从diff开始就变成依次递减了，这个可以优化，优化思路一样，可以成倍的计算，节约时间
```java
class Solution {
    //优化+格式化代码
    public int divide(int dividend, int divisor) {
        //判断符号
        int symbol=(dividend>0&&divisor>0)||(dividend<0&&divisor<0)?1:-1;
        //边界情况直接返回
        if(dividend==Integer.MAX_VALUE&&divisor==1) return dividend;
        if(dividend==Integer.MAX_VALUE&&divisor==-1) return -dividend;
        if(dividend==Integer.MIN_VALUE&&divisor==1) return -dividend;
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
        //放到long中避免Integer.MIN_VALUE的绝对值超过int最大值
        long a=Math.abs((long)dividend),b=Math.abs((long)divisor);
        //记录结果
        int result=0;
        int i=0;
        //temp用于保存最初始的b
        long temp=b;
        //当a恰好是2^n，b=2的时候是存在a=temp的，所以需要加上a==temp的情况
        while(a>=b){
            //左移，相当于b*2
            b=b<<1;
            //a<b情况说明到达临界点了
            if(a<b){
                //计算result的值 2<<(i-1)等价与Math.pow(2,i),如果是i=0的情况说明Math.pow(2,0)就是1
               result=result+(i>0?2<<(i-1):1); 
                //获取差值
               a=a-(b>>1);
                //重新开始计算
               b=temp;
               i=0;
            }else{
                //累计乘2的次数
                i++;
            }
        }
        
        return symbol>0?result:-result;
    }
}
```
优化之后耗时变成2ms