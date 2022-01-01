//**********22. Generate Parentheses
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// Example 2:
// Input: n = 1
// Output: ["()"]

// Constraints:
// 1 <= n <= 8
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n==1){
            ans.add("()");
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        generateBrackets(0,0,n,sb,ans);
        return ans;
    }
    
    public void generateBrackets(int open,int close,int n,StringBuilder sb,List<String>ans){
        if(open==close && close==n){
            ans.add(sb.toString());
            return;
        }
        
        if(open<n){
            sb.append('(');
            generateBrackets(open+1,close,n,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            generateBrackets(open,close+1,n,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
