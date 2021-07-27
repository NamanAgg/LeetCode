//**************128. Longest Consecutive Sequence
//Hard
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//Example 1:
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//Example 2:
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
//Constraints:
//0 <= nums.length <= 104
//-109 <= nums[i] <= 109
import java.util.*;
import java.io.*;
public class LongestConsecutiveSequenceTwo {
	 public int longestConsecutive(int[] arr) {
         HashMap<Integer,Integer>map=new HashMap<>();
    for(int key:arr)
       map.put(key,0);
       
   int sp=0;
   int maxLen=0;
   for(int ele:arr){
       if(map.containsKey(ele)){
           map.remove(ele);
           int le=ele-1;
           int re=ele+1;
           
           while(map.containsKey(le)){
               map.remove(le);
               le-=1;
           }
           
           while(map.containsKey(re)){
               map.remove(re);
               re+=1;
           }
           
           int len=re-le-1;
           if(len>maxLen){
               maxLen=len;
               sp=le+1;
           }
       }
   }    
   
   return maxLen;
   }
}
