//********968. Binary Tree Cameras
// You are given the root of a binary tree. 
//We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
// Return the minimum number of cameras needed to monitor all nodes of the tree.

// Example 1:
// Input: root = [0,0,null,0,0]
// Output: 1
// Explanation: One camera is enough to monitor all nodes if placed as shown.

// Example 2:
// Input: root = [0,0,null,0,null,0,null,null,0]
// Output: 2
// Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

// Constraints:
// The number of nodes in the tree is in the range [1, 1000].
// Node.val == 0

public class BinaryTreeCameras{
    
    public class TreeNode {
        
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

       TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
   

    
    int count = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return minCameraCover_1(root) == -1 ? count + 1 : count;
    }

    // -1 means its parent should cover it
    // 0 means it is covering itself
    // 1 means its child(ren) is covering it
    public int minCameraCover_1(TreeNode root) {
        if (root == null)
            return -2;

        int left = minCameraCover_1(root.left);
        int right = minCameraCover_1(root.right);
        if (left == -2 && right == -2) {
            return -1;
        }
        if (left == -1 || right == -1) {
            count++;
            return 0;
        }

        if (left == 0 || right == 0) {
            return 1;
        }

        return -1;

    }
}