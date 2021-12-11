package ownPractice;
//*******878. Nth Magical Number
// A positive integer is magical if it is divisible by either a or b.
// Given the three integers n, a, and b, return the nth magical number. Since the answer may be very large, return it modulo 109 + 7.

// Example 1:
// Input: n = 1, a = 2, b = 3
// Output: 2

// Example 2:
// Input: n = 4, a = 2, b = 3
// Output: 6

// Example 3:
// Input: n = 5, a = 2, b = 4
// Output: 10

// Example 4:
// Input: n = 3, a = 6, b = 4
// Output: 8
 
// Constraints:
// 1 <= n <= 109
// 2 <= a, b <= 4 * 104
public class NthMagicalNumber {
    public int nthMagicalNumber(int N, int A, int B) {
        long a = A, b = B, tmp, low = 2, high = (long)1e14, mod = (long)1e9 + 7 ,n = N;
       long lcm = findLcm(a,b);
       return (int)(binarySearch(a,b,low,high,lcm,n)%mod);
   }
   
   public long binarySearch(long a,long b,long low,long high,long lcm,long n){
       long mod = (long)1e9 + 7;
       while(low<high){
           long mid = low + (high-low)/2;
           long r1 = mid%a;
           long r2 = mid%b;
           long r3 = mid%lcm;
           long n1 = (mid-r1)/a;
           long n2 = (mid-r2)/b;
           long n3 = (mid-r3)/lcm;
           long tot = n1+n2-n3;
           
           if(tot<n) low = mid+1;
           else high = mid;
       }
       
       return low%mod;
   }
   
   public long findGcd(long x, long y) {  
       if (x == 0)  
           return y;  
       return findGcd(y % x, x);  
   }  
   public long findLcm(long x, long y){  
       return (long)(x / findGcd(x, y)) * y;  
   }     
}