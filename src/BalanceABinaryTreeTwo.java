//***********81382. Balance a Binary Search Tree
// Given a binary search tree, return a balanced binary search tree with the same node values.
// A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.
// If there is more than one answer, return any of them.

// Example 1:
// Input: root = [1,null,2,null,3,null,4,null,null]
// Output: [2,1,3,null,null,null,4]
// Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.

// Constraints:
// The number of nodes in the tree is between 1 and 10^4.
// The tree nodes will have distinct values between 1 and 10^5.
public class BalanceABinaryTreeTwo {
    public int getHeight(TreeNode node) {
        return node == null ? -1 : Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int getBal(TreeNode node) {
        int lh = getHeight(node.left);
        int rh = getHeight(node.right);

        return lh - rh;
    }

    // O(1)
    public TreeNode rightRotation(TreeNode A) {
        TreeNode B = A.left;
        TreeNode BKaRight = B.right;

        B.right = A;
        A.left = BKaRight;

        B.right = getRotation(A);
        return getRotation(B);
    }

    // O(1)
    public TreeNode leftRotation(TreeNode A) {
        TreeNode B = A.right;
        TreeNode BKaLeft = B.left;

        B.left = A;
        A.right = BKaLeft;

        B.left = getRotation(A);
        return getRotation(B);
    }

    // O(1)
    public TreeNode getRotation(TreeNode root) {
        if (getBal(root) >= 2) { // ll,lr
            if (getBal(root.left) >= 1) { // ll
                return rightRotation(root);
            } else { // lr
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }

        } else if (getBal(root) <= -2) { // rr,rl
            if (getBal(root.right) <= -1) { // rr
                return leftRotation(root);
            } else { // rl
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null)
            return null;

        root.left = balanceBST(root.left);
        root.right = balanceBST(root.right);

        return getRotation(root);
    }
 
}
