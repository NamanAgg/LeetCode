package ownPractice;
//************1015. Smallest Integer Divisible by K
// Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k,
// and n only contains the digit 1.
// Return the length of n. If there is no such n, return -1.
// Note: n may not fit in a 64-bit signed integer.

// Example 1:
// Input: k = 1
// Output: 1
// Explanation: The smallest answer is n = 1, which has length 1.

// Example 2:
// Input: k = 2
// Output: -1
// Explanation: There is no such positive integer n divisible by 2.

// Example 3:
// Input: k = 3
// Output: 3
// Explanation: The smallest answer is n = 111, which has length 3.

// Constraints:
// 1 <= k <= 105

//use modulo property 
// Link of the video is : https://www.youtube.com/watch?v=7zovdC157g0
public class SmallestIntegerDivisibleByK {
    //Link to the video : https://www.youtube.com/watch?v=7zovdC157g0
    public int smallestRepunitDivByK(int k) {
        if(k==2 || k==5) return -1;
        
        int n = 1;
        int rem = n%k;
        if(rem==0) return 1;
        for(int counter = 2;counter<=k;counter++){
            int nxtRem = (rem*10+1)%k;
            if(nxtRem==0) return counter;
            rem = nxtRem;
        }
        
        return -1;
    }
}
