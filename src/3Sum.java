//******************15. 3Sum
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
// and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

// Example 2:
// Input: nums = []
// Output: []

// Example 3:
// Input: nums = [0]
// Output: []

// Constraints:
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
public class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>ans =new ArrayList<>();
        if(nums.length<3) return ans; 
        Arrays.sort(nums);
        int n = nums.length;
        
        for(int i =0 ; i<n-2 ; i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            
            int low = i+1;
            int high = n-1;
                
            while(low<high)
                if(nums[i]+nums[low]+nums[high]==0){
                    ans.add(addInSmallList(nums,i,low,high));
                    
                    while(low<high && nums[low]==nums[low+1]) low++;
                    while(low<high && nums[high]==nums[high-1]) high--;
                    
                    low++;
                    high--;
                }
                else if(nums[i]+nums[low]+nums[high]<0) low++;
                else high--;
        }
        
        return ans;
    }
    
    public List<Integer> addInSmallList(int[]nums,int i,int j,int k){
          List<Integer> res = new ArrayList<>();
                res.add(nums[i]);
                res.add(nums[j]);
                res.add(nums[k]);
        return res;
    }
}
