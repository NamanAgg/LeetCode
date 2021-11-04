package ownPractice;
//*************1497. Check If Array Pairs Are Divisible by k
// Given an array of integers arr of even length n and an integer k.
// We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
// Return True If you can find a way to do that or False otherwise.

// Example 1:
// Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
// Output: true
// Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).

// Example 2:
// Input: arr = [1,2,3,4,5,6], k = 7
// Output: true
// Explanation: Pairs are (1,6),(2,5) and(3,4).

// Example 3:
// Input: arr = [1,2,3,4,5,6], k = 10
// Output: false
// Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.

// Example 4:
// Input: arr = [-10,10], k = 2
// Output: true

// Example 5:
// Input: arr = [-1,1,-2,2,-3,3,-4,4], k = 3
// Output: true

// Constraints:
// arr.length == n
// 1 <= n <= 105
// n is even.
// -109 <= arr[i] <= 109
// 1 <= k <= 105
public class CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer>hs = new HashMap<>();
        ///agar array even hi ni hoga to pair to vese hi ni ban payenge
		if(arr.length%2!=0){
		        return false;
		}
		for(int i=0;i<=arr.length-1; i++){
		    int val = arr[i];
		    int mod = val%k;
		    if(mod<0){
		        mod = k+mod;
		    }
		    hs.put(mod,hs.getOrDefault(mod,0)+1);
		}
        ///fir hm hash map par treverse kar ke dekhenge 
		for(Integer val : hs.keySet()){
		    int get = hs.get(val);
            ///agar 0 hai to oska difference k hi hoga jo ki hash map me hoga hi nahi to 0 ke liye check kar lenge agar oski frequency even hai to pair up kar sakta hai
            /// dusra for the even k  agar val k ka half hai to k-val=val hi hoga to os case me bhi val ki frequency even honi chaie
		    if((val==0&&get%2!=0)||(k%2==0&&val*2==k&&get%2!=0)){
		        return false;
		    }else if(val!=0&&val*2!=k){
		        int diff = k-val;
                ///agar diff hai and oska frequency even hai to hm answer true hoga 
		        if(!hs.containsKey(diff)||!hs.get(diff).equals(hs.get(val))){
		        return false;
		        }
		    }
		}
		return true;
    }

}
