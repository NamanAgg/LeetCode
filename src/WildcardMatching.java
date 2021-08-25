//***********44. Wildcard Matching
// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).

// Example 1:
// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".

// Example 2:
// Input: s = "aa", p = "*"
// Output: true
// Explanation: '*' matches any sequence.

// Example 3:
// Input: s = "cb", p = "?a"
// Output: false
// Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

// Example 4:
// Input: s = "adceb", p = "*a*b"
// Output: true
// Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

// Example 5:
// Input: s = "acdcb", p = "a*c?b"
// Output: false

// Constraints:
// 0 <= s.length, p.length <= 2000
// s contains only lowercase English letters.
// p contains only lowercase English letters, '?' or '*'.
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0) return true;
        if(p.length()==0) return false;
        String pattern=""+p.charAt(0);
        int i=1;
        while(i<p.length()){
            if(p.charAt(i)=='*' && p.charAt(i)==pattern.charAt(pattern.length()-1)){
                
            }
            else pattern+=p.charAt(i);
            i++;
        }
        int[][]dp=new int[s.length()+1][pattern.length()+1];
        for(int[]d : dp)
            Arrays.fill(d,-1);
        
        return (isMatch(s,pattern,s.length(),pattern.length(),dp)==1)?true:false;
    }
    
    public int isMatch(String s,String p, int i,int j,int[][]dp){
       if(i==0 ||j==0){
           if(j==1 && p.charAt(j-1)=='*') return dp[i][j]=1;
           if(i==0&&j==0) return dp[i][j]=1;
           else return dp[i][j]=0;
       }
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') 
            dp[i][j]=isMatch(s,p,i-1,j-1,dp); 
        
        else if(p.charAt(j-1)=='*'){
            int starNotAsEmpty=isMatch(s,p,i-1,j,dp); //star matched with current character
            int starAsEmpty=isMatch(s,p,i,j-1,dp);  //star matched with empty string
            dp[i][j]=((starAsEmpty==1) || (starNotAsEmpty==1))?1:0;
        }
        
        else dp[i][j]=0;
        
        return dp[i][j];
    }
}
