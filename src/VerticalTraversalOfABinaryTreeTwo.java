//***********987. Vertical Order Traversal of a Binary Tree 
// Given the root of a binary tree,calculate the vertical order traversal of the binary tree.
// For each node at position(row,col),its left and right children will be at positions(row+1,col-1)and(row+1,col+1)respectively.
// The root of the tree is at(0,0).The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index 
// starting from the leftmost column and ending on the rightmost column.
// There may be multiple nodes in the same row and same column.In such a case,sort these nodes by their values.
// Return the vertical order traversal of the binary tree.

// Example 1:
// Input:root=[3,9,20,null,null,15,7]Output:[[9],[3,15],[20],[7]]
//Explanation:
//Column-1:Only node 9 is in this column.
//Column 0:Nodes 3 and 15 are in this column in that order from top to bottom.
//Column 1:Only node 20 is in this column.
//Column 2:Only node 7 is in this column.

// Example 2:
// Input:root=[1,2,3,4,5,6,7]Output:[[4],[2],[1,5,6],[3],[7]]
//Explanation:
//Column-2:Only node 4 is in this column.
//Column-1:Only node 2 is in this column.
//Column 0:Nodes 1,5,and 6 are in this column.1 is at the top,so it comes first.5 and 6 are at the same position(2,0),so we order them by their value,5 before 6. Column 1:Only node 3 is in this column.Column 2:Only node 7 is in this column.

// Example 3:
// Input:root=[1,2,3,4,6,5,7]Output:[[4],[2],[1,5,6],[3],[7]]
//Explanation:
//This case is the exact same as example 2,but with nodes 5 and 6 swapped.
//Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.

// Constraints:
// The number of nodes in the tree is in the range[1,1000].0<=Node.val<=1000
public class VerticalTraversalOfABinaryTreeTwo {
    public class vPair {
        TreeNode node = null;
        int vl = 0;
        int level = 0;

        vPair(TreeNode node, int vl) {
            this(node, vl, 0);
        }

        vPair(TreeNode node, int vl, int level) {
            this.vl = vl;
            this.node = node;
            this.level = level;
        }
    }

    public void widthOfShadow(TreeNode node, int vl, int[] minMax) {
        if (node == null)
            return;
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);
        widthOfShadow(node.left, vl - 1, minMax);
        widthOfShadow(node.right, vl + 1, minMax);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<vPair> que = new PriorityQueue<>((a, b) -> {
            if (a.level != b.level) {
                return a.level - b.level;
            } else if (a.vl != b.vl)
                return a.vl - b.vl;

            return a.node.val - b.node.val;
        });

        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        int len = minMax[1] - minMax[0] + 1;

        que.add(new vPair(root, Math.abs(minMax[0]), 0));

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++)
            ans.add(new ArrayList<>());

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                vPair rp = que.remove();
                int vl = rp.vl;
                int level = rp.level;
                TreeNode node = rp.node;

                ans.get(vl).add(node.val);

                if (node.left != null)
                    que.add(new vPair(node.left, vl - 1, level + 1));
                if (node.right != null)
                    que.add(new vPair(node.right, vl + 1, level + 1));
            }
        }

        return ans;
    }
}
