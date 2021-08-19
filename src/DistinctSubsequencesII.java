//**************940. Distinct Subsequences II
// Given a string s, return the number of distinct non-empty subsequences of s. Since the answer may be very large, 
// return it modulo 109 + 7.
// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
// of the characters without disturbing the relative positions of the remaining characters.
// (i.e., "ace" is a subsequence of "abcde" while "aec" is not.
 
// Example 1:
// Input: s = "abc"
// Output: 7
// Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".

// Example 2:
// Input: s = "aba"
// Output: 6
// Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "abc".

// Example 3:
// Input: s = "aaa"
// Output: 3
// Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".

// Constraints:
// 1 <= s.length <= 2000
// s consists of lowercase English letters.
public class DistinctSubsequencesII {

public int distinctSubseqII(String s) {
    int n=s.length();
    int[]dp=new int[n+1];
    Arrays.fill(dp,-1);
    int[]freq=new int[26];
    return distinctSub_memo(s,n,dp,freq);
}

public int distinctSub_memo(String s,int n,int[]dp,int[]freq){
    if(n==0) return dp[n]=0;
    
    if(dp[n]!=-1) return dp[n];
    int mod=(int)(Math.pow(10,9)+7);
   
    int prevRes=distinctSub_memo(s,n-1,dp,freq);
    int additonalSum=0;
   if(freq[s.charAt(n-1) - 'a'] == 0){ //we haven't seen this char
        additonalSum  = (1 + prevRes) % mod;
    }else {
        additonalSum = (prevRes - distinctSub_memo(s,freq[s.charAt(n-1)-'a']-1,dp,freq)+mod) % mod;
    }
    freq[s.charAt(n-1) - 'a'] = n;
    dp[n] = (prevRes + additonalSum) % mod;
    
    return dp[n];
}
}