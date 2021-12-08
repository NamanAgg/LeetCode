package ownPractice;
//*********856. Score of Parentheses
// Given a balanced parentheses string s, return the score of the string.
// The score of a balanced parentheses string is based on the following rule:
// "()" has score 1.
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.

// Example 1:
// Input: s = "()"
// Output: 1

// Example 2:
// Input: s = "(())"
// Output: 2

// Example 3:
// Input: s = "()()"
// Output: 2

// Example 4:
// Input: s = "(()(()))"
// Output: 6

// Constraints:
// 2 <= s.length <= 50
// s consists of only '(' and ')'.
// s is a balanced parentheses string.


// Explanation of the solution 
// When travel through S, only meets ')', we need to calculate the score of this pair of parenthese.
// If we know the score of inner parentheses, such as 3, we can double it and pass to the outer parenthese.
// But the question is how do we know the score of inner parentheses? Using stack.

// explain with "( ( ) ( ( ) ) )"

// stack: 0->
// string_traveled :""
// When start only 0 in stack, this int will store the total score

// stack: 0->0->0->
// string_traveled:"( ("
// Meet two '(', push two zeros to the stack

// stack: 0->1->
// string_traveled: "( ( )"
// First time meets ')', it balance the last '(', so pop the stack. But 0 indicates no inner parentheses exists, so just pass 1 to parent parenthese.

// stack: 0->1->0->0->
// string_traveled: "( ( ) ( ("
// Keep pushing zeros

// stack 0->1->1->
// string_traveled: "( ( ) ( ( )"
// Balance one '(', and still no inner parenthese, so pass 1 to parent

// stack 0->3->
// string_traveled: "( ( ) ( ( ) )"
// Balance another '(', but the inner is not zero, so double it and add to parent's score

// stack 6->
// string_traveled: "( ( ) ( ( ) ) )"
// Same as last step, double the inner score and add to parent's
public class ScoreOfParentheses {
    //very important question and the link of the video is given in the notes section and also here too
    //https://www.youtube.com/watch?v=rWsv46ME6lI
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                stack.push(-1);
            }
            else{
                int sum = 0;
                while(stack.peek()!=-1){
                    sum += stack.pop();
                }
                stack.pop();
                stack.push(Math.max(sum*2,1));
            }
        }
        
        while(stack.size()!=0){
            ans+=stack.pop();
        }
        return ans;
    }
}
