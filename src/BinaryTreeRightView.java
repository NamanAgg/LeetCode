//**************199. Binary Tree Right Side View
// Given the root of a binary tree, imagine yourself standing on the right side of it,
// return the values of the nodes you can see ordered from top to bottom.

// Example 1:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

// Example 2:
// Input: root = [1,null,3]
// Output: [1,3]

// Example 3:
// Input: root = []
// Output: []

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
public class BinaryTreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return  new ArrayList<>();
        ArrayList<Integer>ans =new ArrayList<>();
        ArrayList<ArrayList<Integer>> levels =new ArrayList<>();
        LinkedList<TreeNode> que=new LinkedList<>();
        que.add(root);
        
        while(que.size()!=0){
            int size=que.size();
            ArrayList<Integer>level=new ArrayList<>();
            while(size-->0){
                TreeNode node=que.removeFirst();
                level.add(node.val);
                if(node.left!=null) que.addLast(node.left);
                if(node.right!=null) que.addLast(node.right);
            }
            levels.add(level);
        }
        
        for(ArrayList<Integer> level : levels)
            ans.add(level.get(level.size()-1));
        
        return ans;
    }
}
