//**************102. Binary Tree Level Order Traversal
// Given the root of a binary tree, return the level order traversal of its nodes' values.
// (i.e., from left to right, level by level).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []

// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        
        return res;
    }
}
