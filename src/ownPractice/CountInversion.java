package ownPractice;
//********************Count Inversions 
// https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#

// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
// If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count
// is the maximum. 
// Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 
// Example 1:
// Input: N = 5, arr[] = {2, 4, 1, 3, 5}
// Output: 3
// Explanation: The sequence 2, 4, 1, 3, 5 
// has three inversions (2, 1), (4, 1), (4, 3).

// Example 2:
// Input: N = 5
// arr[] = {2, 3, 4, 5, 6}
// Output: 0
// Explanation: As the sequence is already 
// sorted so there is no inversion count.

// Example 3:
// Input: N = 3, arr[] = {10, 10, 10}
// Output: 0
// Explanation: As all the elements of array 
// are same, so there is no inversion count.

// Your Task:
// You don't need to read input or print anything.
// Your task is to complete the function inversionCount() which takes the array arr[] and the
// size of the array as inputs and returns the inversion count of the given array.

// Expected Time Complexity: O(NLogN).
// Expected Auxiliary Space: O(N).

// Constraints:
// 1 ≤ N ≤ 5*105
// 1 ≤ arr[i] ≤ 1018
public class CountInversion {
    static long count = 0;
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        count = 0;
        mergeSort(arr,0,(int)N-1);
        return count;
    }
    
    static long[] mergeSort(long arr[],int lo,int hi){
        if(lo==hi) return new long[]{arr[lo]};
        
        int mid = lo + (hi-lo)/2;
        
        long[]left = mergeSort(arr,lo,mid);
        long[]right = mergeSort(arr,mid+1,hi);
        return mergeAndCount(left,right);
    }
    
    static long[] mergeAndCount(long[]left,long[]right){
        int n = left.length, m = right.length;
        long[] res = new long[n+m];
        
        int i = 0 ,j = 0, k =0;
        long myCount =0;
        while(i<n && j<m){
            long val1 = left[i];
            long val2 = right[j];
            if(val1>val2){
                myCount+= n-i;
                res[k++] = val2;
                j++;
            }
            else{
                res[k++] = val1;
                i++;
            }
        }
        
        while(i<n){
            res[k++] = left[i++];
        }
        
        while(j<m){
            res[k++] = right[j++];
        }
        
        count+=myCount;
        return res;
    }
}
