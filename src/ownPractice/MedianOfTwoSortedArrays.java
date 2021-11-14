//***************4. Median of Two Sorted Arrays
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).

// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

// Example 3:
// Input: nums1 = [0,0], nums2 = [0,0]
// Output: 0.00000

// Example 4:
// Input: nums1 = [], nums2 = [1]
// Output: 1.00000

// Example 5:
// Input: nums1 = [2], nums2 = []
// Output: 2.00000

// Constraints:
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
          int n2 = b.length;
  
          if(n1 > n2) return findMedianSortedArrays(b,a);
  
          int lo = 0;
          int hi = n1;
          int te = n1 + n2;
          while(lo <= hi) {
              int ali = lo + (hi - lo) / 2; // aleft is equivalent to mid, ali-> a left index
              int bli = (te + 1) / 2 - ali; // why te + 1, because we have to manage odd and even both, bli-> b left index
  
              int alm1 = ali == 0 ? Integer.MIN_VALUE : a[ali - 1];
              int al = ali == n1 ? Integer.MAX_VALUE : a[ali];
              int blm1 = bli == 0 ? Integer.MIN_VALUE : b[bli - 1];
              int bl = bli == n2 ? Integer.MAX_VALUE : b[bli];
  
              // make sure that splitting is valid or not
              if(alm1 <= bl && blm1 <= al) {
                  // after is here in this block
                  double median = 0.0;
                  if(te % 2 == 0) {
                      // even elements
                      median = (Math.max(blm1, alm1) + Math.min(al, bl)) / 2.0;
                  } else {
                      // odd elements
                      median = Math.max(alm1, blm1);
                  }
                  return median;
              } else if(blm1 > al) {
                  lo = ali + 1;
              } else {
                  hi = ali -1;
              }
          }
          return 0.0;
      }
}
