//***************1003. Check If Word Is Valid After Substitutions
// Given a string s, determine if it is valid.
// A string s is valid if, starting with an empty string t = "", you can transform t into s after performing
// the following operation any number of times:
// Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright.
// Note that tleft and tright may be empty.
// Return true if s is a valid string, otherwise, return false.

// Example 1:
// Input: s = "aabcbc"
// Output: true
// Explanation:
// "" -> "abc" -> "aabcbc"
// Thus, "aabcbc" is valid.

// Example 2:
// Input: s = "abcabcababcc"
// Output: true
// Explanation:
// "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
// Thus, "abcabcababcc" is valid.

// Example 3:
// Input: s = "abccba"
// Output: false
// Explanation: It is impossible to get "abccba" using the operation.

// Example 4:
// Input: s = "cababc"
// Output: false
// Explanation: It is impossible to get "cababc" using the operation.

// Constraints:
// 1 <= s.length <= 2 * 104
// s consists of letters 'a', 'b', and 'c'
public class CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();
        for(Character ch : s.toCharArray()){
            if(ch=='b')
                if(stack.isEmpty() || stack.peek()!='a') return false;
            if(ch=='c')
                if(stack.size()<2 || stack.pop()!='b' || stack.pop()!='a') return false;
            
            if(ch!='c') stack.push(ch);
        }
        
        return stack.isEmpty();
    }
}
