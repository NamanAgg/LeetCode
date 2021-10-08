//*****************1028. Recover a Tree From Preorder Traversal
// We run a preorder depth-first search (DFS) on the root of a binary tree.
// At each node in this traversal, we output D dashes (where D is the depth of this node),
// then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.
// The depth of the root node is 0.
// If a node has only one child, that child is guaranteed to be the left child.
// Given the output traversal of this traversal, recover the tree and return its root.

// Example 1:
// Input: traversal = "1-2--3--4-5--6--7"
// Output: [1,2,5,3,4,6,7]

// Example 2:
// Input: traversal = "1-2--3---4-5--6---7"
// Output: [1,2,5,3,null,6,null,4,null,7]

// Example 3:
// Input: traversal = "1-401--349---90--88"
// Output: [1,401,null,349,88,90]
 
// Constraints:
// The number of nodes in the original tree is in the range [1, 1000].
// 1 <= Node.val <= 109
public class RecoverATreeFromPreOrderTraversal {
    public class pair{
        TreeNode node;
        int level;
        pair(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public TreeNode recoverFromPreorder(String str) {
        Stack<pair> stack = new Stack<>();
        int idx=0;
        while(idx<str.length() && str.charAt(idx)!='-'){
            idx++;
        }
        int rootNum = Integer.parseInt(str.substring(0,idx));
        TreeNode root = new TreeNode(rootNum,null,null);
        stack.push(new pair(root,0));
        while(idx<str.length()){
            int level=0;
            while(str.charAt(idx)=='-'){ //calc of depth
                idx++;
                level++;
            }
            int pos=idx;
            while(idx<str.length() && str.charAt(idx)!='-'){ //calc of number
                idx++;
            }
            int num = Integer.parseInt(str.substring(pos,idx));
            TreeNode node = new TreeNode(num,null,null);
            
            pair p = stack.peek();
            if(p.level+1==level){
                if(p.node.left==null) p.node.left=node;
                else  p.node.right=node;
                stack.push(new pair(node,level));
            }
            
            else{
                while(stack.size()!=0 && (stack.peek().level+1)!=level)
                    stack.pop();
                if(stack.size()!=0){
                    p = stack.peek();
                    if(p.node.left==null) p.node.left=node;
                    else if(p.node.right==null) p.node.right=node;
                    else stack.pop();
                    stack.push(new pair(node,level));  
                }
                else break;
            }
        }
        
        return root;
    }
}
