//*******************107. Binary Tree Level Order Traversal II
// Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
// (i.e., from left to right, level by level from leaf to root).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[15,7],[9,20],[3]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []
 
// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
         return new ArrayList<>();
     List<List<Integer>> res = new ArrayList<>();
     
     LinkedList<TreeNode> que = new LinkedList<>();
     que.add(root);
     while(que.size()!=0){
         int size = que.size();
         List<Integer> smallAns = new ArrayList<>();
         while(size-->0){
             TreeNode rm = que.removeFirst();
             smallAns.add(rm.val);
             
             if(rm.left!=null) que.add(rm.left);
             if(rm.right!=null) que.add(rm.right);
         }
         res.add(smallAns);
     }
     
     Collections.reverse(res);
     return res;
 }
}
