package ownPractice;
//***********229. Majority Element II
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
// Follow-up: Could you solve the problem in linear time and in O(1) space?

// Example 1:
// Input: nums = [3,2,3]
// Output: [3]

// Example 2:
// Input: nums = [1]
// Output: [1]

// Example 3:
// Input: nums = [1,2]
// Output: [1,2]

// Constraints:
// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109

// **important question based on moore voting algo and plz see the video ArraysAndStrings1LevelUp for more understanding**
public class MajorityElements2 {
    protected boolean isMajority(int[]arr,int num){
        int count=0;
        for(Integer e : arr)
            if(e==num) count++;
        
        return count>arr.length/3?true:false;    
            
    }
    
    public List<Integer> majorityElement(int[] arr) {
        List<Integer> ans =new ArrayList<>();
        int val1=arr[0]; //just initializing
        int val2=arr[0]; //just initializing
        int counter1=0;
        int counter2=0;
        
        for(int i =0;i<arr.length;i++){
            if(val1==arr[i])
                counter1++;
            else if(val2==arr[i])
                counter2++;
            else{
                if(counter1==0){
                    val1=arr[i];
                    counter1++;
                }
                else if(counter2==0){
                    val2=arr[i];
                    counter2++;
                }
                else{
                    counter1--;
                    counter2--;
                }
            }
        }
        if(isMajority(arr,val1))
            ans.add(val1);
        
        if(val2!=val1 && isMajority(arr,val2))
            ans.add(val2);
        
        return ans;    
    }
}
