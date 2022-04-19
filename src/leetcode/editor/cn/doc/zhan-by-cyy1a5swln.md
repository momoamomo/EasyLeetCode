### 解题思路
最基础的思路：栈
三对符号。字符串将字符顺序放入栈，只要是左边那个就不管，如果是右边的，就判断两种情况：
1.栈里最后一个是不是跟它匹配，是的话就一起弹出去
2.如果不匹配，那这个字符串肯定不成立了，return false（仔细看就会发现这个规律）
全部入栈匹配完后，也剩下两种情况：
1.如果栈是空的，说明全部匹配结束，return true
2.如果栈是非空的，说明有不匹配的，return false

### 代码

```java
class Solution {
   public boolean isValid(String s) {
		//40 41 91 93 123 125
		int a[]=new int[126];
		a[41]=40;a[93]=91;a[125]=123;
		ArrayList<Integer> arr=new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			int k=s.charAt(i);
			if(k==40 || k==91 || k==123) {
				arr.add(k);
			}else {
				if(arr.size()==0) {
					return false;
				}
				int tem=arr.remove(arr.size()-1);
				if(a[k]!=tem) {
					return false;
				}
			}
		}
		if(arr.size()==0)
			return true;
		else
			return false;
	}
}
```