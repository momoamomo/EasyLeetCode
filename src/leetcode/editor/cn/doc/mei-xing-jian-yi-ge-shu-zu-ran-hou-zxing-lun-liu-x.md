```
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) {
            return s;
        }
        ArrayList<LinkedList<Character>> resArrayList=new ArrayList<>();
        for(int i=0;i<numRows;i++) {  //有多少行就建几个数组
            resArrayList.add(new LinkedList<>());
        }
        int k=0;
        int flag=1;
        for(int i=0;i<s.length();i++) {
            resArrayList.get(k).add(s.charAt(i));
            k+=flag;	
            if(k==0)     //到第一行了，开始正向添加进数组
                flag=1;
            if(k==numRows-1)   //到最后一行了，反向添加
                flag=-1;
        }
        String result="";
        for(int i=0;i<numRows;i++) {   //把每一行的数据拼接起来
            for(int j=0;j<resArrayList.get(i).size();j++) {
                result+=resArrayList.get(i).get(j);
            }
        }
        return result;
    }
}
```
