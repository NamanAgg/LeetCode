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
    int[]size;
    int[]par;
    public int findPar(int u){
        return (u==par[u]) ? u : (par[u] = findPar(par[u]));
    }
    
    public int unionFind(int a ,int b){
        int p1 = findPar(a);
        int p2 = findPar(b);
        int s1 = size[p1];
        int s2 = size[p2];
        if(p1!=p2){
            if(s1>s2){
                size[p1] += size[p2];
                par[p2] = p1;
            }
            else{
                size[p2] += size[p1];
                par[p1] = p2;
            }
        }
    }
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        size = new int[n];
        par = new int[n];
        for(int i=0;i<n;i++){
            par[i] = nums[i];
            size[i] = 1;
        }
        
        
    }
}
