//************1359. Count All Valid Pickup and Delivery Options
// Given n orders, each order consist in pickup and delivery services. 
// Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 
// Since the answer may be too large, return it modulo 10^9 + 7.

// Example 1:
// Input: n = 1
// Output: 1
// Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.

// Example 2:
// Input: n = 2
// Output: 6
// Explanation: All possible orders: 
// (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
// This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.

// Example 3:
// Input: n = 3
// Output: 90

// Constraints:
// 1 <= n <= 500
class CountAllValidPickupAndDeliveryOptions{
    public int countOrders(int n) {
        if(n==1) return 1;
         
        int prevAns = 1;   
        long mod = 1000000007;
        for(int i=2;i<=n;i++){
             long k = (long) (i*2 -1);    // k = total number of places in n-1
             long each = (k*(k+1))/2;     // total possibilities in each case of n-1
             long total = each * (long)prevAns;    // total possibilities for n 
             prevAns = (int) (total%mod);
         }
         return prevAns;
     }
}
