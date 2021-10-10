//****************449. Serialize and Deserialize BST
// Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
// or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
// Design an algorithm to serialize and deserialize a binary search tree.
// There is no restriction on how your serialization/deserialization algorithm should work.
// You need to ensure that a binary search tree can be serialized to a string,
// and this string can be deserialized to the original tree structure.
// The encoded string should be as compact as possible.

// Example 1:
// Input: root = [2,1,3]
// Output: [2,1,3]

// Example 2:
// Input: root = []
// Output: []

// Constraints:
// The number of nodes in the tree is in the range [0, 104].
// 0 <= Node.val <= 104
// The input tree is guaranteed to be a binary search tree.
public class SerializeAndDeserializeBST {
    public class Codec {

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
                    // sb.append("# ");
                    continue;
                } else
                    sb.append(rnode.val + " ");
    
                que.addLast(rnode.left);
                que.addLast(rnode.right);
            }
    
            return sb.toString();
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String str) {
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
}
