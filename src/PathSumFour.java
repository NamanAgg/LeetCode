//***********113. Path Sum II
// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
// A leaf is a node with no children.

// Example 1:
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: [[5,4,11,2],[5,8,4,5]]

// Example 2:
// Input: root = [1,2,3], targetSum = 5
// Output: []

// Example 3:
// Input: root = [1,2], targetSum = 0
// Output: []

// Constraints:
// The number of nodes in the tree is in the range [0, 5000].
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
public class PathSumFour {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        pathSum_(root, targetSum, res, ans);
        return ans;
    }

    public void pathSum_(TreeNode root, int targetSum, List<Integer> res, List<List<Integer>> ans) {
        if (root == null || targetSum - root.val != 0 && root.right == null && root.left == null)
            return;
        if (targetSum - root.val == 0 && root.right == null && root.left == null) {
            List<Integer> base = new ArrayList<>(res);
            base.add(root.val);
            ans.add(base);
            return;
        }
        res.add(root.val);
        pathSum_(root.left, targetSum - root.val, res, ans);
        pathSum_(root.right, targetSum - root.val, res, ans);
        res.remove(res.size() - 1);

    } 
}
