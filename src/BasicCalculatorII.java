//********227. Basic Calculator II
// Given a string s which represents an expression, evaluate this expression and return its value. 
// The integer division should truncate toward zero.
// You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

// Example 1:
// Input: s = "3+2*2"
// Output: 7

// Example 2:
// Input: s = " 3/2 "
// Output: 1

// Example 3:
// Input: s = " 3+5 / 2 "
// Output: 5

// Constraints:
// 1 <= s.length <= 3 * 105
// s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
// s represents a valid expression.
// All the integers in the expression are non-negative integers in the range [0, 231 - 1].
// The answer is guaranteed to fit in a 32-bit integer.
public class BasicCalculatorII {
    public int calculate(String s) {
        int currNo = 0;
       char op = '+';
       int len = s.length();
       Stack<Integer> stack = new Stack<>();
       
       for(int i=0;i<len;i++){
           char ch = s.charAt(i);
           
           //check for digit
           if(Character.isDigit(ch)){
               currNo = (currNo * 10) + (ch - '0');
           }
           
           //check for operator
           if(!Character.isDigit(ch) && ch != ' ' || i == len-1){
               if(op == '+'){
                   stack.push(currNo);
               }else if(op == '-'){
                   stack.push(-currNo);
               }else if(op == '*'){
                   stack.push(stack.pop()*currNo);
               }else if(op == '/'){
                   stack.push(stack.pop()/currNo);
               }
               currNo = 0;
               op = ch;
           }
       }
       int sum = 0;
       while(!stack.isEmpty()){
           sum += stack.pop();
       }
       return sum;
   }
}
