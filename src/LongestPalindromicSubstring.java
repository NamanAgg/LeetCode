//**************5. Longest Palindromic Substring
// Given a string s, return the longest palindromic substring in s.

// Example 1:
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

// Example 2:
// Input: s = "cbbd"
// Output: "bb"

// Constraints:
// 1 <= s.length <= 1000
// s consist of only digits and English letters.
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][]dp = new int[n][n];
        for(int[]d:dp)
            Arrays.fill(d,-1);
        longestSubString(s,0,n-1,dp);
        
        int maxI=0,maxJ=0;
        int maxAns = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(dp[i][j]==1){
                    if(maxAns<Math.abs(j-i)+1){
                        maxI = i;
                        maxJ = j;
                        maxAns = Math.abs(j-i)+1;
                    }
                }
            }
        
        return s.substring(maxI,maxJ+1);
    }
    
    public int longestSubString(String str,int i,int j,int[][]dp){
        if(i>j) return dp[i][j] = 0;
        if(i==j) return dp[i][j] = 1;
        if(dp[i][j]!=-1) return dp[i][j];
        
        char ch1 = str.charAt(i);
        char ch2 = str.charAt(j);
        if(i+1==j && ch1==ch2) return dp[i][j] = 1;
        
        if(ch1!=ch2){
             longestSubString(str,i+1,j,dp);
             longestSubString(str,i,j-1,dp);
            longestSubString(str,i+1,j-1,dp);
            dp[i][j] = 0;
        }
        else{
            dp[i][j] = longestSubString(str,i+1,j-1,dp);
            longestSubString(str,i+1,j,dp);
            longestSubString(str,i,j-1,dp);
        }
        
        return dp[i][j];
    }
}
