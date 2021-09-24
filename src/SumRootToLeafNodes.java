//*************129. Sum Root to Leaf Numbers
// You are given the root of a binary tree containing digits from 0 to 9 only.
// Each root-to-leaf path in the tree represents a number.
// For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
// Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
// A leaf node is a node with no children.

// Example 1:
// Input: root = [1,2,3]
// Output: 25
// Explanation:
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
// Therefore, sum = 12 + 13 = 25.

// Example 2:
// Input: root = [4,9,0,5,1]
// Output: 1026
// Explanation:
// The root-to-leaf path 4->9->5 represents the number 495.
// The root-to-leaf path 4->9->1 represents the number 491.
// The root-to-leaf path 4->0 represents the number 40.
// Therefore, sum = 495 + 491 + 40 = 1026.

// Constraints:
// The number of nodes in the tree is in the range [1, 1000].
// 0 <= Node.val <= 9
// The depth of the tree will not exceed 10.
public class SumRootToLeafNodes {
    //     public int sumNumbers(TreeNode root) {
//         if(root.left==null && root.right==null) return root.val;
//         ArrayList<String> list=new ArrayList<>();
//         rootToLeafPaths(root,"",list);
//         preprocessing(list);
//         int sum=0;
//         for(String str : list)
//             sum+=Integer.parseInt(str);
        
//         return sum;
 
//     }
    
//     public void rootToLeafPaths(TreeNode root,String res,ArrayList<String>list){
//         if(root==null) return;
        
//         res+=root.val;
//         if(root.left==null && root.right==null){
//             list.add(res);
//             return;
//         } 
        
//         rootToLeafPaths(root.left,res,list);
//         rootToLeafPaths(root.right,res,list);
//     }
    
    
//     public void preprocessing(ArrayList<String>list){
//         for(int i =0;i<list.size();i++){
//             String str = list.get(i);
//             if(str.charAt(0)=='0'){
//                int j=0;
//                 while(str.charAt(j)==0){
//                     j++;
//                 }
//                 str=str.substring(j);
//                 list.set(i,str);
//             }
//         }
//     }
    
public int sumNumbers(TreeNode root) {
    return sumNodes(root, 0);
  }

  private int sumNodes(TreeNode root, int currentSum) {
    if (root == null) return 0;
    currentSum = currentSum * 10 + root.val;
    if (root.left == null && root.right == null) return currentSum;
    int leftSum = sumNodes(root.left, currentSum);
    int rightSum = sumNodes(root.right, currentSum);
    return leftSum + rightSum;
  }
    
}
