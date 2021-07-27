//************863. All Nodes Distance K in Binary Tree************88
//VERY IMPORTANT
//We are given a binary tree (with root node root), a target node, and an integer value K.
//Return a list of the values of all nodes that have a distance K from the target node.  
//The answer can be returned in any order.
//Example 1:
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//Output: [7,4,1]
//Explanation: 
//The nodes that are a distance 2 from the target node (with value 5)
//have values 7, 4, and 1.
//Note that the inputs "root" and "target" are actually TreeNodes.
//The descriptions of the inputs above are just serializations of these objects.
//Note:
//The given tree is non-empty.
//Each node in the tree has unique values 0 <= node.val <= 500.
//The target node is a node in the tree.
//0 <= K <= 1000.
import java.util.*;
import java.io.*;
public class AllNodesDistanceKInBinaryTreeTwo {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	   public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
			 ArrayList<TreeNode> list=new ArrayList<TreeNode>();
			 boolean res=rootToNodePath(root,target.val,list);
			 if(!res) {
				 List<Integer> base=new ArrayList<>();
				 return base;
			 }
			 List<Integer> ans=new ArrayList<Integer>();
			 int i=K;
			 int j=0;
	       TreeNode block=null;
			 while(j<list.size()) {
				 printAtKDepth(list.get(j),i,block,ans);
	             block=list.get(j);
				 j++;
				 i--;
			 }
			
			 return ans;
			 
		    }
	  public static boolean rootToNodePath(TreeNode root, int data, ArrayList<TreeNode> ans) {
	        if (root == null)
	            return false;
	        boolean res = (root.val == data) || rootToNodePath(root.left, data, ans)
	                || rootToNodePath(root.right, data, ans);

	        if (res)
	            ans.add(root);
	        return res;
	    }

	    public static void printAtKDepth(TreeNode root, int k,TreeNode block, List<Integer> ans) {
	        if(root == null || root==block|| k < 0) return;

	        if(k == 0){
	            ans.add(root.val);
	            return;
	        }

	        printAtKDepth(root.left, k - 1, block, ans);
	        printAtKDepth(root.right, k - 1, block, ans);
	    }

}
