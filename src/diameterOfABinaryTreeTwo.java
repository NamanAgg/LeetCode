//**********543. Diameter of Binary Tree
// Given the root of a binary tree, return the length of the diameter of the tree.
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
// This path may or may not pass through the root.
// The length of a path between two nodes is represented by the number of edges between them.

// Example 1:
// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].

// Example 2:
// Input: root = [1,2]
// Output: 1

// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -100 <= Node.val <= 100
public class diameterOfABinaryTreeTwo {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] dia = new int[1];
        diameter(root, dia);
        return dia[0];
    }

    public int diameter(TreeNode root, int[] dia) {
        if (root == null)
            return -1;

        int left = diameter(root.left, dia);
        int right = diameter(root.right, dia);

        dia[0] = Math.max(dia[0], left + right + 2);

        return (left > right ? left : right) + 1;
    }
}
