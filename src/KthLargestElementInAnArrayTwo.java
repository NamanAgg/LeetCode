//**************************215. Kth Largest Element in an Array
//Given an integer array nums and an integer k, return the kth largest element in the array.
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//Example 1:
//Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
//
//Example 2:
//Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
//
//Constraints:
//1 <= k <= nums.length <= 104
//-104 <= nums[i] <= 104
import java.util.*;
import java.io.*;
public class KthLargestElementInAnArrayTwo {
	public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void downHeapify(int[] nums, int pi, int li) {
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if (lci <= li && nums[lci] > nums[maxIdx])
            maxIdx = lci;
        if (rci <= li && nums[rci] > nums[maxIdx])
            maxIdx = rci;

        if (pi != maxIdx) {
            swap(nums, pi, maxIdx);
            downHeapify(nums, maxIdx, li);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--)
            downHeapify(nums, i, n - 1);

        int li = n - 1;
        while (k > 1) {
            swap(nums, 0, li--);
            downHeapify(nums, 0, li);
            k--;
        }

        return nums[0];
    }
}
