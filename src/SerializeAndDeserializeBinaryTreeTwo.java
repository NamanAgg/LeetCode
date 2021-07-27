//*****************297. Serialize and Deserialize Binary Tree
// Share Serialization is the process of converting a data structure or object into a sequence of bits so that it 
// can be stored in a file or memory buffer,or transmitted across a network connection link to be 
// reconstructed later in the same or another computer environment.
// Design an algorithm to serialize and deserialize a binary tree.
// There is no restriction on how your serialization/deserialization algorithm should work.
// You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
// Clarification:The input/output format is the same as how LeetCode serializes a binary tree.You do not necessarily need to follow this format,
// so please be creative and come up with different approaches yourself.

// Example 1:
// Input:root=[1,2,3,null,null,4,5]Output:[1,2,3,null,null,4,5]

// Example 2:
// Input:root=[]Output:[]

// Example 3:
// Input:root=[1]Output:[1]

// Example 4:
// Input:root=[1,2]Output:[1,2]

// Constraints:
// The number of nodes in the tree is in the range[0,104].
// -1000<=Node.val<=1000
public class SerializeAndDeserializeBinaryTreeTwo{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        StringBuilder sb = new StringBuilder();

        while (que.size() != 0) {
            TreeNode rnode = que.removeFirst();
            if (rnode == null) {
                sb.append("# ");
                continue;
            } else
                sb.append(rnode.val + " ");

            que.addLast(rnode.left);
            que.addLast(rnode.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.

    public static TreeNode deserialize(String str) {
        if (str.length() == 0)
            return null;

        LinkedList<TreeNode> que = new LinkedList<>();
        String[] arr = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        que.addLast(root);

        int i = 1, n = arr.length;
        while (i < n) {
            TreeNode rnode = que.removeFirst();
            if (i < n && !arr[i].equals("#")) {
                TreeNode lci = new TreeNode(Integer.parseInt(arr[i]));
                rnode.left = lci;
                que.addLast(lci);
            }
            i++;

            if (i < n && !arr[i].equals("#")) {
                TreeNode rci = new TreeNode(Integer.parseInt(arr[i]));
                rnode.right = rci;
                que.addLast(rci);
            }
            i++;
        }

        return root;
    }

}