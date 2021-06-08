//*****Find First and Last Position of Element in Sorted Array
//Given an array of integers nums sorted in ascending order, 
//find the starting and ending position of a given target value.
//If target is not found in the array, return [-1, -1].
//Follow up: Could you write an algorithm with O(log n) runtime complexity?
//Example 1:8
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//Example 3:
//Input: nums = [], target = 0
//Output: [-1,-1]
//Constraints:
//0 <= nums.length <= 105
//-109 <= nums[i] <= 109
//nums is a non-decreasing array.
//-109 <= target <= 109
import java.util.*;
import java.io.*;
public class FindFirstAndLastPositionOfElementInSortedArray {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=scn.nextInt();//size of array
		int[]arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=scn.nextInt();
		int target=scn.nextInt();
		int[]res=searchRange(arr,target);
		System.out.println("["+res[0]+","+res[1]+"]");
	}
    public static int[] searchRange(int[] nums, int target) {
        int[]res=new int[2];
        res[0]=findFirstIndex(nums,target);
        res[1]=findLastIndex(nums,target);
        return res;
    }
    
    public static int findFirstIndex(int[]arr,int target){
        int si=0;
        int ei=arr.length-1;
        int pos=-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(arr[mid]<target)
                si=mid+1;
            else if(arr[mid]>target)
                ei=mid-1;
            else{
                pos=mid;
                ei=mid-1;
            }
        }
        return pos;
        
    }
    public static int findLastIndex(int[]arr,int target){
        int si=0;
        int ei=arr.length-1;
        int pos=-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(arr[mid]<target)
                si=mid+1;
            else if(arr[mid]>target)
                ei=mid-1;
            else{
                pos=mid;
                si=mid+1;
            }
        }
        return pos;    
    }

}
