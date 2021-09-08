//*************95. Unique Binary Search Trees II
// Given an integer n, return all the structurally unique BST's (binary search trees),
// which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

// Example 1:
// Input: n = 3
// Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

// Example 2:
// Input: n = 1
// Output: [[1]]

// Constraints:
// 1 <= n <= 8
public class UniqueBinarySearchTreesII {
//   Definition for a binary tree node.
//   public class TreeNode {
//       int val;
//       TreeNode left;
//       TreeNode right;
//       TreeNode() {}
//       TreeNode(int val) { this.val = val; }
//       TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//       }
//   }
 
public void generateAllBST(int num, List<TreeNode> left,List<TreeNode>right, List<TreeNode> ans){
    if(left.size()!=0 && right.size()!=0)
        for(int i=0;i<left.size();i++)
            for(int j=0;j<right.size();j++){
                TreeNode root=new TreeNode(num);
                root.left=left.get(i);
                root.right=right.get(j);
                ans.add(root);
            }
    else if(left.size()!=0)
        for(int i=0;i<left.size();i++){
            TreeNode root = new TreeNode(num);
            root.left=left.get(i);
            ans.add(root);
        }
    else if(right.size()!=0)
        for(int j=0;j<right.size();j++){
            TreeNode root = new TreeNode(num);
            root.right=right.get(j);
            ans.add(root);
        }
    else
        ans.add(new TreeNode(num));
    
}

public List<TreeNode> generateTrees(int si,int ei){
    List<TreeNode> ans = new ArrayList<>();
    for(int cut = si ; cut<=ei ; cut++){
        List<TreeNode> leftList= generateTrees(si,cut-1);
        List<TreeNode> rightList= generateTrees(cut+1,ei);
        
        generateAllBST(cut,leftList,rightList,ans);
    }
    
    return ans;
}
public List<TreeNode> generateTrees(int n) {
    return generateTrees(1,n);
}
}
