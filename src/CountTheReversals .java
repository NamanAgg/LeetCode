// https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1#
// Count the Reversals 
// Given a string S consisting of only opening and closing curly brackets '{' and '}',
// find out the minimum number of reversals required to convert the string into a balanced expression.
// A reversal means changing '{' to '}' or vice-versa.

// Example 1:
// Input:
// S = "}{{}}{{{"
// Output: 3
// Explanation: One way to balance is:
// "{{{}}{}}". There is no balanced sequence
// that can be formed in lesser reversals.

// Example 2:
// Input: 
// S = "{{}{{{}{{}}{{"
// Output: -1
// Explanation: There's no way we can balance
// this sequence of braces.

// Expected Time Complexity: O(|S|).
// Expected Auxiliary Space: O(1).

// Constraints:
// 1 ≤ |S| ≤ 105


public class CountTheReversals  {
    int countRev (String s)
    {
        // your code here  
        char[]arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(char ch : arr){
            if(ch=='{')
                stack.push(ch);
            else{
                if(stack.size()!=0 && stack.peek()=='{')
                    stack.pop();
                else 
                    stack.push(ch);
            }
        }
        // System.out.println(stack);
        if(stack.size()%2!=0) return -1;
        int close = 0;
        int open = 0;
        while(stack.size()!=0){
            if(stack.pop()=='{') open++;
            else close++;
        }
        
        
        
        return (close+1)/2+(open+1)/2;
    }
}
