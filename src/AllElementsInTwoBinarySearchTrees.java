//*************1305. All Elements in Two Binary Search Trees
// Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

// Example 1:
// Input: root1 = [2,1,4], root2 = [1,0,3]
// Output: [0,1,1,2,3,4]

// Example 2:
// Input: root1 = [1,null,8], root2 = [8,1]
// Output: [1,1,8,8]

// Constraints:
// The number of nodes in each tree is in the range [0, 5000].
// -105 <= Node.val <= 105

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1= new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        addLeftElements(root1,stack1);
        addLeftElements(root2,stack2);
        
        while(stack1.size()!=0 && stack2.size()!=0){
            TreeNode node1 = stack1.peek();
            TreeNode node2 = stack2.peek();
            if(node1.val<node2.val){
                ans.add(node1.val);
                stack1.pop();
                if(node1.right!=null) addLeftElements(node1.right,stack1);
            }
            else{
                ans.add(node2.val);
                stack2.pop();
                if(node2.right!=null) addLeftElements(node2.right,stack2);
            }
        }
        
        if(stack1.size()!=0) addRemainingElements(stack1, ans);
        if(stack2.size()!=0) addRemainingElements(stack2, ans);
        
        return ans;
        
    }
    
    public void addLeftElements(TreeNode node, Stack<TreeNode> stack){
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
        
    }
    public void addRemainingElements(Stack<TreeNode> stack, List<Integer> ans){
        while(stack.size()!=0){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.right!=null) addLeftElements(node.right,stack);
        }
    }
}
