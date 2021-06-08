import java.util.Scanner;
import java.util.*;
//TwoSum
//Given an array of integers nums and an integer target, return indices of the two numbers 
//such that they add up to target.
//You may assume that each input would have exactly one solution, 
//and you may not use the same element twice.
//You can return the answer in any order.
//Example 1:
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//Example 2:
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//Example 3:
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//Constraints:
//2 <= nums.length <= 103
//-109 <= nums[i] <= 109
//-109 <= target <= 109
//Only one valid answer exists.
public class TwoSum {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=scn.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++)
			arr[i]=scn.nextInt();
		int target=scn.nextInt();
		int []answer=twoSum(arr,target);
			
		System.out.print(Arrays.toString(answer));
		
		
	}
	 public static int[] twoSum(int[] nums, int target) {
	        int[] ans=new int[2];
	        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
	        for(int i=0;i<nums.length;i++)
	        {
	        	if(hmap.containsKey(target-nums[i]))
	        	{
	        		ans[0]=i;
	        		ans[1]= hmap.get(target-nums[i]);
	        		break;
	        	}
	        	hmap.put(nums[i], i);
	        }
	        return ans;
	        
	    }
	 
	 
}
