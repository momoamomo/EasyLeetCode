### 解题思路
这道题的题目和三数之和具有几乎一样的思路，对于很多第一次接触三数相加问题的朋友来说，双指针看上去非常难以掌握，但是，只要将这两道题加以比较，并且分析比较写法，就不难总结出双指针方法解决这类问题的步骤通则，而且双指针方法在代码上也是非常好写的。
下面，我们以这道题为例，总结总结双指针问题解决三数相加问题上的通用方法。
1.将数组进行排序，因为双指针会逐渐缩小搜索范围，排序就相当必要。
2.固定开始的数begin，双指针解决三数问题，自然就需要将一个数字确定下来。
3.将left初始化为begin之后的数，right初始化为最末尾的数，我们之后采用两头逼近的方式，也就是双指针。
4.如果begin + left + right > target, 我们在脑子中应该有这样一个数轴图，数轴上有三个点，分别代表begin、left、right，这个时候如果再继续向右移动left，只会让整个式子更大，不合题意，自然需要将right向左移动。
5.如果begin + left + right < target，依靠那个数轴图，我们不难想到应该是left++；
6.过程中不断更新cloest值，最后返回最接近的值即可。

### 代码

```java
class Solution {
    /*
        类似于三数之和，先排序。
        遍历第一个数的位置，双指针向中间逼近，不断更新最接近的值
    */
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);

        //遍历第一个数的位置
        for(int begin = 0; begin < nums.length-2; begin++){
            //双指针逼近中间位置
            int left = begin+1;
            int right = nums.length-1;
            while(right > left){
                int cur = nums[begin] + nums[left] + nums[right];
                if(Math.abs(closest-target) > Math.abs(cur-target))   
                    closest = cur;
                if(cur > target) 
                    right--;
                else if(cur < target)   
                    left++;
                else    
                    return target;
            }
        }
        return closest;
    }
}
```