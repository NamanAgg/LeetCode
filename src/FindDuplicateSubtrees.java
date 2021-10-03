//*************652. Find Duplicate Subtrees
// Given the root of a binary tree, return all duplicate subtrees.
// For each kind of duplicate subtrees, you only need to return the root node of any one of them.
// Two trees are duplicate if they have the same structure with the same node values.

// Example 1:
// Input: root = [1,2,3,4,null,2,4,null,null,4]
// Output: [[2,4],[4]]

// Example 2:
// Input: root = [2,1,1]
// Output: [[1]]

// Example 3:
// Input: root = [2,2,2,3,null,3,null]
// Output: [[2,3],[3]]

// Constraints:
// The number of the nodes in the tree will be in the range [1, 10^4]
// -200 <= Node.val <= 200
public class FindDuplicateSubtrees {
    HashMap<String,Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        findDuplicateSubtrees(root,ans);
        return ans;
    }
    
    public String findDuplicateSubtrees(TreeNode root,List<TreeNode>ans){
        if(root==null) return "$";
        
        String left = findDuplicateSubtrees(root.left,ans);
        String right = findDuplicateSubtrees(root.right,ans);
        
        String res = root.val+"!"+left+"!"+right;
        // int res = Integer.parseInt(str);
        
        map.put(res,map.getOrDefault(res,0)+1);
        if(map.get(res)==2) {
            System.out.println(res);
            ans.add(root);
        }
        
        return res;
    }
}
