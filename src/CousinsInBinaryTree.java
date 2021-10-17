//**************993. Cousins in Binary Tree
// Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
// return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
// Two nodes of a binary tree are cousins if they have the same depth with different parents.
// Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

// Example 1:
// Input: root = [1,2,3,4], x = 4, y = 3
// Output: false

// Example 2:
// Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
// Output: true

// Example 3:
// Input: root = [1,2,3,null,4], x = 2, y = 3
// Output: false

// Constraints:
// The number of nodes in the tree is in the range [2, 100].
// 1 <= Node.val <= 100
// Each node has a unique value.
// x != y
// x and y are exist in the tree.
public class CousinsInBinaryTree {
    class pair{
        int depth;
        TreeNode par;
        pair(TreeNode parent,int depth){
            this.depth = depth;
            this.par = parent;
        }
        pair(){
            
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
       if(root==null) return false;
        
        pair firstVal = find(root,null,0,x);
        pair secondVal = find(root,null,0,y);
        
        if(firstVal.par!=secondVal.par && firstVal.depth==secondVal.depth) return true;
        return false;
    }
    
    
    public pair find(TreeNode root,TreeNode par,int k,int x){
        if(root==null) return new pair(par,-1);
        
        if(root.val==x) return new pair(par,k);
        
        pair left = find(root.left,root,k+1,x);
        pair right = find(root.right,root,k+1,x);
        return (left.depth!=-1)?left:right;
    }
}
