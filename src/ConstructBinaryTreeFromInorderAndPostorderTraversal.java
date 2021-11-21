//***********106. Construct Binary Tree from Inorder and Postorder Traversal
// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
// postorder is the postorder traversal of the same tree, construct and return the binary tree.

// Example 1:
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

// Example 2:
// Input: inorder = [-1], postorder = [-1]
// Output: [-1]

// Constraints:
// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder and postorder consist of unique values.
// Each value of postorder also appears in inorder.
// inorder is guaranteed to be the inorder traversal of the tree.
// postorder is guaranteed to be the postorder traversal of the tree.
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    HashMap<Integer,Integer> map = new HashMap<>(); //inorder map
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int count = 0;
        for(Integer e : inorder)
            map.put(e,count++);
        
        return buildUsingInAndPost(postorder,postorder.length-1,0,inorder.length-1);
        
    }
    
    public TreeNode buildUsingInAndPost(int[]postorder,int psi,int isi,int iei){
        if(isi>iei) return null;
        
        int inIdx  = map.get(postorder[psi]);
        int tel = iei - inIdx;
        
        TreeNode root = new TreeNode(postorder[psi]);
        
        root.right = buildUsingInAndPost(postorder,psi-1,inIdx+1,iei);
        root.left = buildUsingInAndPost(postorder,psi-tel-1,isi,inIdx-1);
        return root;
    }
}
