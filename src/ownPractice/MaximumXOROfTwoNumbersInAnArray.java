package ownPractice;
//************421. Maximum XOR of Two Numbers in an Array
// Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

// Example 1:
// Input: nums = [3,10,5,25,2,8]
// Output: 28
// Explanation: The maximum result is 5 XOR 25 = 28.

// Example 2:
// Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
// Output: 127

// Constraints:
// 1 <= nums.length <= 2 * 105
// 0 <= nums[i] <= 231 - 1
public class MaximumXOROfTwoNumbersInAnArray {
    public static class Trie{
        /* we kind of use binary tree concept of left & right
        X
       / \
    L 0   1 R
      */
        public class Node{
            Node left, right;
        }
        Node root;
        Trie(){
            root = new Node();
        }
        public void insert(int val){
            int bitIndex = 30; // 0 ---- 30 [31] bit's
            Node curr = root;
            
            while(bitIndex >= 0){
                int mask = 1<<bitIndex;
                int bit = (mask&val) > 0 ? 1 : 0;
                // Till now our root is empty,
                if(bit == 0){ // but if we get 0 we will add it to it's left
                    if(curr.left == null){
                        curr.left = new Node();
                    }
                    curr = curr.left;
                }
                else{ // if we get 1 we will add it to it's right 
                    if(curr.right == null){
                        curr.right = new Node();
                    }
                    curr = curr.right;
                }
                bitIndex--;
            }
        }
        public int query(int find){
            int bitIndex = 30; // 0 ---- 30 [31] bit's
            Node curr = root;
            int ans = 0;
            while(bitIndex >= 0){
                int mask = 1<<bitIndex;
                int bit = (find&mask) > 0 ? 1 : 0;
                
                if(bit == 0){
                    if(curr.left != null)
                        curr = curr.left;
                    else{
                        curr = curr.right;
                        ans |= mask;
                    }
                }
                else{
                    if(curr.right != null){
                        curr = curr.right;
                        ans |= mask;
                    }
                    else
                        curr = curr.left;
                }
                
                bitIndex--;
            }
            return ans;
        } 
    }
    public int findMaximumXOR(int[] nums) {
        // Actual logic
        Trie trie = new Trie();
        
        for(int val : nums)
            trie.insert(val);
        
        int max = 0;
        for(int a : nums){
            int find = Integer.MAX_VALUE ^ a;
            int b = trie.query(find);
            max = Math.max(max, a ^ b);
        }
        return max;
    }
}
