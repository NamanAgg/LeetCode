//****************97. Interleaving String
// Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
// An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
// Note: a + b is the concatenation of strings a and b.

// Example 1:
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true

// Example 2:
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
// Output: false

// Example 3:
// Input: s1 = "", s2 = "", s3 = ""
// Output: true

// Constraints:
// 0 <= s1.length, s2.length <= 100
// 0 <= s3.length <= 200
// s1, s2, and s3 consist of lowercase English letters.

// Follow up: Could you solve it using only O(s2.length) additional memory space?
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(),n = s2.length();
        if((m+n)!=s3.length()) return false;
        int[][]dp = new int[m+1][n+1];
        for(int[]d : dp)
            Arrays.fill(d,-1);
        return (isInterLeave(s1,s2,s3,m,n,s3.length(),dp)==0)?false:true;
    }
    
    public int isInterLeave(String s1,String s2,String s3,int i,int j,int idx,int[][]dp){
        if(idx==0) return dp[i][j]=1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        char ch1 = s3.charAt(idx-1);
        if(i!=0 && j!=0 && s1.charAt(i-1)==ch1 && ch1==s2.charAt(j-1)){
             int val1 = isInterLeave(s1,s2,s3,i-1,j,idx-1,dp);
             int val2 = isInterLeave(s1,s2,s3,i,j-1,idx-1,dp);
             return dp[i][j] = Math.max(val1,val2);
        }
        if(i!=0 && s1.charAt(i-1)==ch1) 
            return dp[i][j] = isInterLeave(s1,s2,s3,i-1,j,idx-1,dp);
        
        if(j!=0 && s2.charAt(j-1)==ch1)
            return dp[i][j] = isInterLeave(s1,s2,s3,i,j-1,idx-1,dp);
        
        return dp[i][j]=0;
    }
}
