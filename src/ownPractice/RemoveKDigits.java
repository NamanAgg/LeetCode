package ownPractice;
//***********402. Remove K Digits
// Given string num representing a non-negative integer num, and an integer k,
// return the smallest possible integer after removing k digits from num.

// Example 1:
// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

// Example 2:
// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

// Example 3:
// Input: num = "10", k = 2
// Output: "0"
// Explanation: Remove all the digits from the number and it is left with nothing which is 0.

// Constraints:
// 1 <= k <= num.length <= 105
// num consists of only digits.
// num does not have any leading zeros except for the zero itself.
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(k>=num.length()) return "0";
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<num.length()){
            char ch = num.charAt(i);
            if(stack.isEmpty() || stack.peek()<=ch){
                stack.push(ch);
                i++;
            }
            else{
                if(k>0){
                    stack.pop();
                    k--;
                }
                else{
                    stack.push(ch);
                    i++;
                }
                
            }
        }
        
        while(k-->0) stack.pop();
        
        
        while(stack.size()!=0) sb.append(stack.pop());
        
        
        int j = sb.length()-1;
        while(j>=0 && sb.charAt(j)=='0'){
            j--;
        }
        sb.delete(j+1,sb.length());
        
        return sb.length()==0?"0":sb.reverse().toString();
    }
}
