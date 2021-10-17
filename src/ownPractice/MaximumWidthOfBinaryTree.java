//*******************662. Maximum Width of Binary Tree
// Given the root of a binary tree, return the maximum width of the given tree.
// The maximum width of a tree is the maximum width among all levels.
// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
// where the null nodes between the end-nodes are also counted into the length calculation.
// It is guaranteed that the answer will in the range of 32-bit signed integer.

// Example 1:
// Input: root = [1,3,2,5,3,null,9]
// Output: 4
// Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

// Example 2:
// Input: root = [1,3,null,5,3]
// Output: 2
// Explanation: The maximum width existing in the third level with the length 2 (5,3).

// Example 3:
// Input: root = [1,3,2,5]
// Output: 2
// Explanation: The maximum width existing in the second level with the length 2 (3,2).

// Example 4:
// Input: root = [1,3,2,5,null,null,9,6,null,null,7]
// Output: 8
// Explanation: The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).

// Constraints:
// The number of nodes in the tree is in the range [1, 3000].
// -100 <= Node.val <= 100
public class MaximumWidthOfBinaryTree {
    public class pair{
        TreeNode node;
        long pos;
        pair(TreeNode node,long pos){
            this.node = node;
            this.pos=pos;
        }
        pair(){
            
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        long ans = Integer.MIN_VALUE;
        LinkedList<pair> que = new LinkedList<>();
        que.add(new pair(root,0));
        while(que.size()!=0){
            int size = que.size();
            ans = Math.max(ans,que.getLast().pos-que.getFirst().pos+1);
            while(size-- > 0){
                pair rm = que.removeFirst();
                if(rm.node.left!=null)
                    que.addLast(new pair(rm.node.left,2*rm.pos+1));
                if(rm.node.right!=null)
                    que.addLast(new pair(rm.node.right,2*rm.pos+2));
            }
        }
        return (int)ans;
    }
}
