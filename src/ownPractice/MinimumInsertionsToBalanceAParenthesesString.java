package ownPractice;
//**********1541. Minimum Insertions to Balance a Parentheses String
// Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
// Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
// Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
// In other words, we treat '(' as openning parenthesis and '))' as closing parenthesis.
// For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
// You can insert the characters '(' and ')' at any position of the string to balance it if needed.
// Return the minimum number of insertions needed to make s balanced.

// Example 1:
// Input: s = "(()))"
// Output: 1
// Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching.
// We need to to add one more ')' at the end of the string to be "(())))" which is balanced.

// Example 2:
// Input: s = "())"
// Output: 0
// Explanation: The string is already balanced.

// Example 3:
// Input: s = "))())("
// Output: 3
// Explanation: Add '(' to match the first '))', Add '))' to match the last '('.

// Example 4:
// Input: s = "(((((("
// Output: 12
// Explanation: Add 12 ')' to balance the string.

// Example 5:
// Input: s = ")))))))"
// Output: 5
// Explanation: Add 4 '(' at the beginning of the string and one ')' at the end. The string becomes "(((())))))))".

// Constraints:
// 1 <= s.length <= 10^5
// s consists of '(' and ')' only.
public class MinimumInsertionsToBalanceAParenthesesString {
    //what we have done is firstly replaced all those "))" to '}' then we will use the simple brackets balance
    //push only '(' in the stack, whenever we encounter '}' we will pop if top of stack is '(' else increase our count
    // by one(bcz it means we need to insert a '(' character in string.), if character is ')' then
    // if the there is top of stack present which will be '('(if stack is not empty) then we will pop
    // but also increase our count by one(bcz it mean in the stirg we have () this combination present and we have
    // to add ')' to make it balanced) but if the top of stack is not present or stack is empty then we will increase
    // our count by 2(it means we have only ')' present in stack and for this case we need to insert '(' and this too ')').
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        s = s.replace("))","}");
        char[]arr = s.toCharArray();
        int i=0;
        int count = 0;
        for(Character ch  :arr){
            if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                count++;
                if(!stack.isEmpty()) stack.pop();
                else count++;
            }
            else{
                if(!stack.isEmpty())
                        stack.pop();
                else count+=1;
            }
        }
        
        return stack.size()*2 + count;
    }
}
