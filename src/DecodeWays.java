//***************91. Decode Ways
// A message containing letters from A-Z can be encoded into numbers using the following mapping:
// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"
// To decode an encoded message, all the digits must be grouped then mapped back into letters
// using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
// "AAJF" with the grouping (1 1 10 6)
// "KJF" with the grouping (11 10 6)
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
// Given a string s containing only digits, return the number of ways to decode it.
// The answer is guaranteed to fit in a 32-bit integer.

// Example 1:
// Input: s = "12"
// Output: 2
// Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

// Example 2:
// Input: s = "226"
// Output: 3
// Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

// Example 3:
// Input: s = "0"
// Output: 0
// Explanation: There is no character that is mapped to a number starting with 0.
// The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
// Hence, there are no valid ways to decode this since all digits need to be mapped.

// Example 4:
// Input: s = "06"
// Output: 0
// Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

// Constraints:
// 1 <= s.length <= 100
// s contains only digits and may contain leading zero(s).
public class DecodeWays {
    public int numDecodings(String s) {
        int[]dp=new int[s.length()+1];
         Arrays.fill(dp,-1);
         //int ans=numDecodings_memo(s,0,dp);
         //int ans =numDecodings_dp(s,0,dp);
         int ans=numDecodings_opti(s);
         // for(int ele:dp)
         //     System.out.print(ele+" ");
         return ans;
     }
     
     public int numDecodings_memo(String s,int idx,int[]dp){
         if(idx==s.length())
             return dp[idx]=1;
         
         if(dp[idx]!=-1) return dp[idx];
         
         if(s.charAt(idx)=='0') return dp[idx]=0;
         
         int count=0;
         count+= numDecodings_memo(s,idx+1,dp);
         
         if(idx<s.length()-1){
             int num = (s.charAt(idx)-'0')*10+(s.charAt(idx+1)-'0');
             if(num>=10&&num<=26)
                 count+=numDecodings_memo(s,idx+2,dp);
         }
         
         return dp[idx]=count;
     }
     
        public int numDecodings_dp(String s,int IDX,int[]dp){
         for(int idx=s.length();idx>=IDX;idx--){   
         if(idx==s.length()){
             dp[idx]=1;
             continue;
         }
             
         if(s.charAt(idx)=='0'){
             dp[idx]=0;
             continue;
         }
         
         int count=0;
         count+= dp[idx+1];
         
         if(idx<s.length()-1){
             int num = (s.charAt(idx)-'0')*10+(s.charAt(idx+1)-'0');
             if(num>=10&&num<=26)
                 count+=dp[idx+2];
         }
         
         dp[idx]=count;
         }
            return dp[IDX];
     }
     
     public int numDecodings_opti(String s){
        int prev=1;
        int secPrev=0;
        for(int idx=s.length()-1;idx>=0;idx--){   
            int ans=0;
            if(s.charAt(idx)=='0'){
             secPrev=prev;
             prev=ans;
             continue;
            }
       
            ans+= prev;
            if(idx<s.length()-1){
             int num = (s.charAt(idx)-'0')*10+(s.charAt(idx+1)-'0');
             if(num>=10&&num<=26)
                ans+=secPrev;
             }
             secPrev=prev;
             prev=ans;
         }
         return prev;
     }    

}
