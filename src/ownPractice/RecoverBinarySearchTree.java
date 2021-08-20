//************99. Recover Binary Search Tree
// You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake.
// Recover the tree without changing its structure.
// Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

// Example 1:
// Input: root = [1,3,null,null,2]
// Output: [3,1,null,null,2]
// Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

// Example 2:
// Input: root = [3,1,4,null,null,2]
// Output: [2,1,4,null,null,3]
// Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.

// Constraints:
// The number of nodes in the tree is in the range [2, 1000].
// -231 <= Node.val <= 231 - 1
public package ownPractice;
// find those two  nodes first and used morris order traversal and
// then after finding those 2 nodes which doesnt satisfy bst condtion, just swap their values.
class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
TreeNode first = null;
TreeNode second = null;
TreeNode node=root;
while(node != null){
    if(node.left == null){
        if(first == null && prev.val > node.val){
            first = prev;
            second = node;
        }else if(prev.val > node.val){
            second = node;
        }
        prev = node;
        node = node.right;
    }else{
        TreeNode temp = node.left;
        
        while(temp.right != null && temp.right != node){
            temp = temp.right;
        }
        
        if(temp.right == null){
            temp.right = node;
            node = node.left;
        }else{
            if(first == null && prev.val > node.val){
                first = prev;
                second = node;
            }else if(prev.val > node.val){
                second = node;
            }
            prev = node;
            temp.right = null;
            node = node.right;
        }
    }
} 
int temp = first.val;
first.val = second.val;
second.val = temp;

}
}