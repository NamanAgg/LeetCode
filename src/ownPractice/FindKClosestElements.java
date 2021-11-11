package ownPractice;
//****************658. Find K Closest Elements
// Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
// The result should also be sorted in ascending order.
// An integer a is closer to x than an integer b if:
// |a - x| < |b - x|, or
// |a - x| == |b - x| and a < b

// Example 1:
// Input: arr = [1,2,3,4,5], k = 4, x = 3
// Output: [1,2,3,4]

// Example 2:
// Input: arr = [1,2,3,4,5], k = 4, x = -1
// Output: [1,2,3,4]

// Constraints:
// 1 <= k <= arr.length
// 1 <= arr.length <= 104
// arr is sorted in ascending order.
// -104 <= arr[i], x <= 104
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {    
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return Math.abs(b-x) - Math.abs(a-x);
        });
        
        for(int i=0;i<k;i++)
            pq.add(arr[i]);
        
        for(int i=k;i<arr.length;i++){
            int val = Math.abs(arr[i]-x);
            int pk = Math.abs(pq.peek()-x);
            if(val<pk){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        
        while(pq.size()!=0)
            ans.add(pq.remove());
        
        
        Collections.sort(ans);
        return ans;
    }
}
