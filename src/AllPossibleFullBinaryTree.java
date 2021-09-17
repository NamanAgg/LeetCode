//***************894. All Possible Full Binary Trees
// Given an integer n, return a list of all possible full binary trees with n nodes.
// Each node of each tree in the answer must have Node.val == 0.
// Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
// A full binary tree is a binary tree where each node has exactly 0 or 2 children.

// Example 1:
// Input: n = 7
// Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]

// Example 2:
// Input: n = 3
// Output: [[0,0,0]]

// Constraints:
// 1 <= n <= 20
public class AllPossibleFullBinaryTree {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        System.out.println(ans.size());
        if(n%2==0) return ans; //not possible to create a full BT when number of node are even.
        
        List<TreeNode>[][] dp =new List[n+1][n+1];
        
        for(List<TreeNode>[]d : dp)
            for(List<TreeNode> e : d)
                e=new ArrayList<TreeNode>();
        
          // for(List<TreeNode>[]d : dp)
          //   for(List<TreeNode> e : d)
          //       System.out.print(e+" ");
        
        
        return possibleFBT(0,n-1,n);
        
    }
    
    public List<TreeNode> possibleFBT(int start,int end,int n){
    
        List<TreeNode> ans = new ArrayList<>();
        if(start<0 || end==n ||start>end){
            return new ArrayList<>();
        }
        if(start==end){
            ans.add(new TreeNode(0,null,null));
            return ans;
        }
        
        for(int i =start+1;i<=end;i++){
            List<TreeNode>left = possibleFBT(start,i-1,n);
            List<TreeNode>right = possibleFBT(i+1,end,n);
            if(left.size()!=0 && right.size()!=0){
                for(TreeNode le : left)
                    for(TreeNode ri :right)
                        ans.add(new TreeNode(0,le,ri));
            }
            
        }
        
        return ans;
    }      
}
