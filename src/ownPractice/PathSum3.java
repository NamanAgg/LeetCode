//**********437. Path Sum III
// Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the
// path equals targetSum.
// The path does not need to start or end at the root or a leaf, but it must go downwards
// (i.e., traveling only from parent nodes to child nodes).

// Example 1:
// Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
// Output: 3
// Explanation: The paths that sum to 8 are shown.

// Example 2:
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: 3

// Constraints:
// The number of nodes in the tree is in the range [0, 1000].
// -109 <= Node.val <= 109
// -1000 <= targetSum <= 1000
 package ownPractice;
// this question is just the tree version of ques **find the total number of subarray sum equal to k **

// **here we have to use prefix sum technique and  store the prefix sums in hashmap**

// **link of the video are given below**

// **for the same ques=>** https://www.youtube.com/watch?v=yyZA4v0x16w

// **for the subarray sum equal to k=>** https://www.youtube.com/watch?v=MHocw0bP1rA&t=241s
public class PathSum3 {
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        getTotalPathSums(root,map,0,targetSum);
        return ans;    
    }
    
    public void getTotalPathSums(TreeNode root,HashMap<Integer,Integer>map,int sumSoFar, int targetSum){
        if(root==null) return;
        
        sumSoFar+=root.val;
        if(map.containsKey(sumSoFar-targetSum)){
            ans+=map.get(sumSoFar-targetSum);
        }
        map.put(sumSoFar,map.getOrDefault(sumSoFar,0)+1);
        
        getTotalPathSums(root.left,map,sumSoFar,targetSum);
        getTotalPathSums(root.right,map,sumSoFar,targetSum);
        
       
        map.put(sumSoFar,map.get(sumSoFar)-1);
    }
}
