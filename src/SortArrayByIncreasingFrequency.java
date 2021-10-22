//***************1636. Sort Array by Increasing Frequency
// Given an array of integers nums, sort the array in increasing order based on the frequency of the values.\
// If multiple values have the same frequency, sort them in decreasing order.
// Return the sorted array.

// Example 1:
// Input: nums = [1,1,2,2,2,3]
// Output: [3,1,1,2,2,2]
// Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

// Example 2:
// Input: nums = [2,3,1,3,2]
// Output: [1,3,3,2,2]
// Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

// Example 3:
// Input: nums = [-1,1,-6,4,5,-6,1,4,1]
// Output: [5,-1,4,4,-6,-6,1,1,1]

// Constraints:
// 1 <= nums.length <= 100
// -100 <= nums[i] <= 100
public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer>freq = new HashMap<>();
       for(int i=0;i<nums.length;i++)
           freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
       freq = sortByValue(freq);
       int[]ans = new int[nums.length];
       int i=0;
       for(Map.Entry<Integer,Integer> lhmap : freq.entrySet()){
           int val = lhmap.getValue();
           int key = lhmap.getKey();
           while(val-->0)
               ans[i++] = key;
       }
       
       return ans;
   }

    public HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm){
       List<Map.Entry<Integer, Integer> > list =new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
       Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
           public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2){
               // return (o1.getValue()).compareTo(o2.getValue());
               int v = o1.getValue() - o2.getValue();
               if(v==0) return o2.getKey()-o1.getKey();
               return v;
           }
       });
        
       HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
       for (Map.Entry<Integer, Integer> aa : list) {
           temp.put(aa.getKey(), aa.getValue());
       }
       return temp;
   }
}
