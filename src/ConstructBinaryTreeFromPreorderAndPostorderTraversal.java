//*************************889. Construct Binary Tree from Preorder and Postorder Traversal
// Return any binary tree that matches the given preorder and postorder traversals.
// Values in the traversals pre and post are distinct positive integers.

// Example 1:
// Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
// Output: [1,2,3,4,5,6,7]

// Note:
// 1 <= pre.length == post.length <= 30
// pre[] and post[] are both permutations of 1, 2, ..., pre.length.
// It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal{
    public TreeNode constructFromPrePost(int[] pre, int psi, int pei, int[] post, int ppsi, int ppei) {
        if (psi > pei)
            return null;

        TreeNode root = new TreeNode(pre[psi]);
        if (psi == pei)
            return root;

        int idx = ppsi;
        while (post[idx] != pre[psi + 1])
            idx++;

        int tnel = idx - ppsi + 1;

        root.left = constructFromPrePost(pre, psi + 1, psi + tnel, post, ppsi, idx);
        root.right = constructFromPrePost(pre, psi + tnel + 1, pei, post, idx + 1, ppei - 1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        int n = pre.length;
        return constructFromPrePost(pre, 0, n - 1, post, 0, n - 1);
    }
}