//**************1026. Maximum Difference Between Node and Ancestor
// Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b
// where v = |a.val - b.val| and a is an ancestor of b.
// A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

// Example 1:
// Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
// Output: 7
// Explanation: We have various ancestor-node differences, some of which are given below :
// |8 - 3| = 5
// |3 - 7| = 4
// |8 - 1| = 7
// |10 - 13| = 3
// Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

// Example 2:
// Input: root = [1,null,2,null,0,3]
// Output: 3

// Constraints:
// The number of nodes in the tree is in the range [2, 5000].
// 0 <= Node.val <= 105
public class MaximumDifferenceBetweenNodeAndAncestor {
    class pair{
        int max;
        int min;
        int myAns;
        pair(int max,int min,int myAns){
            this.max = max;
            this.min = min;
            this.myAns = myAns;
        }
        pair(int val){
            this.max = val;
            this.min = val;
            this.myAns = 0;
        }
        pair(){
            this.max = 0;
            this.min = 0;
            this.myAns = 0;
        }
    }
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestor(root).myAns;
    }
    
    public pair maxAncestor(TreeNode root){
        if(root==null) return null;
        if(root.right==null && root.left==null) return new pair(root.val);
        
        pair myPair = new pair(root.val);
        
        pair left = maxAncestor(root.left);
        pair right = maxAncestor(root.right);
        
         if(left!=null){
             myPair.max = Math.max(myPair.max,left.max);
             myPair.min = Math.min(myPair.min,left.min);
             int diff = Math.max(Math.abs(root.val - myPair.max),Math.abs(root.val-myPair.min));
             myPair.myAns = Math.max(Math.abs(root.val-root.left.val),Math.max(myPair.myAns,diff));
             myPair.myAns = Math.max(myPair.myAns,left.myAns);
            }
        
        if(right!=null){
             myPair.max = Math.max(myPair.max,right.max);
             myPair.min = Math.min(myPair.min,right.min);
             int diff = Math.max(Math.abs(root.val - myPair.max),Math.abs(root.val-myPair.min));
             myPair.myAns = Math.max(Math.abs(root.val-root.right.val),Math.max(myPair.myAns,diff));
             myPair.myAns = Math.max(myPair.myAns,right.myAns);
            }
           
        return myPair;
    }
}
