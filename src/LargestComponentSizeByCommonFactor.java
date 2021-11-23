//*************952. Largest Component Size by Common Factor
// You are given an integer array of unique positive integers nums. Consider the following graph:
// There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
// There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
// Return the size of the largest connected component in the graph.

// Example 1:
// Input: nums = [4,6,15,35]
// Output: 4

// Example 2:
// Input: nums = [20,50,9,63]
// Output: 2

// Example 3:
// Input: nums = [2,3,6,7,4,12,21,39]
// Output: 8

// Constraints:
// 1 <= nums.length <= 2 * 104
// 1 <= nums[i] <= 105
// All the values of nums are unique.
public class LargestComponentSizeByCommonFactor {
    int[]par;
    public int findPar(int u){
        return (u==par[u]) ? u : (par[u] = findPar(par[u]));
    }
    
    public void unionFind(int a ,int b){
        int p1 = findPar(a);
        int p2 = findPar(b);
        
        if(p1!=p2)
            par[p1] = p2;
    }
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        int max = findMax(nums);
        par = new int[max+1];
        for(int i=0;i<par.length;i++)
            par[i] = i;
        
        
        for(Integer e : nums){
            for(int i=2;i*i<=e;i++){
                if(e%i==0){
                    unionFind(e,i);
                    unionFind(e,e/i);
                }
            }
        }
        
        HashMap<Integer,Integer> freqMapParent = new HashMap<>();
        for(Integer e : nums)
            freqMapParent.put(findPar(e),freqMapParent.getOrDefault(findPar(e),0)+1);
        
        int ans = 0;
        for(int e : freqMapParent.keySet())
            ans = Math.max(freqMapParent.get(e),ans);
        
        return ans;
    }
    
    public int findMax(int[]arr){
        int max = Integer.MIN_VALUE;
        for(Integer e : arr)
            max = Math.max(max,e);
        return max;
    }
}
