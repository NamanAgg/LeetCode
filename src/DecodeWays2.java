//*************639. Decode Ways II
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
// In addition to the mapping above, an encoded message may contain the '*' character, which can represent any digit from '1' to '9'
// ('0' is excluded). For example, the encoded message "1*" may represent any of the encoded messages
// "11", "12", "13", "14", "15", "16", "17", "18", or "19".
// Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.
// Given a string s consisting of digits and '*' characters, return the number of ways to decode it.
// Since the answer may be very large, return it modulo 109 + 7.

// Example 1:
// Input: s = "*"
// Output: 9
// Explanation: The encoded message can represent any of the encoded messages "1", "2", "3", "4", "5", "6", "7", "8", or "9".
// Each of these can be decoded to the strings "A", "B", "C", "D", "E", "F", "G", "H", and "I" respectively.
// Hence, there are a total of 9 ways to decode "*".

// Example 2:
// Input: s = "1*"
// Output: 18
// Explanation: The encoded message can represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19".
// Each of these encoded messages have 2 ways to be decoded (e.g. "11" can be decoded to "AA" or "K").
// Hence, there are a total of 9 * 2 = 18 ways to decode "1*".

// Example 3:
// Input: s = "2*"
// Output: 15
// Explanation: The encoded message can represent any of the encoded messages "21", "22", "23", "24", "25", "26", "27", "28", or "29".
// "21", "22", "23", "24", "25", and "26" have 2 ways of being decoded, but "27", "28", and "29" only have 1 way.
// Hence, there are a total of (6 * 2) + (3 * 1) = 12 + 3 = 15 ways to decode "2*".

// Constraints:
// 1 <= s.length <= 105
// s[i] is a digit or '*'.
public class DecodeWays2 {
    public long numDecodingsStar(String s,int idx,long[]dp){
        if(idx==s.length()){
            return dp[idx]=1;
        }
        if(dp[idx]!=-1)
            return dp[idx];
        
        if(s.charAt(idx)=='0'){
            return dp[idx]=0;
        }
        
        long count=0;
        int mod=(int)1e9+7;
        char ch1=s.charAt(idx);
        if(ch1=='*'){
            count=(count+9*numDecodingsStar(s,idx+1,dp))%mod;
            
            if(idx<s.length()-1){
                if(s.charAt(idx+1)=='*')
                    count=(count+15*numDecodingsStar(s,idx+2,dp))%mod;
                else if(s.charAt(idx+1)>='0' && s.charAt(idx+1)<='6')
                    count=(count+2*numDecodingsStar(s,idx+2,dp))%mod;
                else if(s.charAt(idx+1)>='7')
                    count=(count+numDecodingsStar(s,idx+2,dp))%mod;
            }
        }
        else{
            count=(count+numDecodingsStar(s,idx+1,dp))%mod;
                
            if(idx<s.length()-1){
                if(s.charAt(idx+1)!='*'){
                    int num=(s.charAt(idx)-'0')*10+(s.charAt(idx+1)-'0');
                    if(num<=26)
                        count=(count+numDecodingsStar(s,idx+2,dp))%mod;
                }
                else{
                    if(ch1=='1')
                        count=(count+9*numDecodingsStar(s,idx+2,dp))%mod;
                    else if(ch1=='2')
                        count=(count+6*numDecodingsStar(s,idx+2,dp))%mod;
                }
            }    
        }
        
        return dp[idx]=count;
        
    }
    
    public long numDecodingsStar_tabu(String s,int IDX,long[]dp){
        for(int idx=s.length();idx>=IDX;idx--){
        if(idx==s.length()){
            dp[idx]=1;
            continue;
        }
            
        if(s.charAt(idx)=='0'){
            dp[idx]=0;
            continue;
        }
        
        long count=0;
        int mod=(int)1e9+7;
        char ch1=s.charAt(idx);
        if(ch1=='*'){
            count=(count+9*dp[idx+1])%mod;
            
            if(idx<s.length()-1){
                if(s.charAt(idx+1)=='*')
                    count=(count+15*dp[idx+2])%mod;
                else if(s.charAt(idx+1)>='0' && s.charAt(idx+1)<='6')
                    count=(count+2*dp[idx+2])%mod;
                else if(s.charAt(idx+1)>='7')
                    count=(count+dp[idx+2])%mod;
            }
        }
        else{
            count=(count+dp[idx+1])%mod;
                
            if(idx<s.length()-1){
                if(s.charAt(idx+1)!='*'){
                    int num=(s.charAt(idx)-'0')*10+(s.charAt(idx+1)-'0');
                    if(num<=26)
                        count=(count+dp[idx+2])%mod;
                }
                else{
                    if(ch1=='1')
                        count=(count+9*dp[idx+2])%mod;
                    else if(ch1=='2')
                        count=(count+6*dp[idx+2])%mod;
                }
            }    
        }
        
         dp[idx]=count;
        }
        return dp[IDX];
    }
        
    public int numDecodings(String s) {
        int n=s.length();
        long[]dp=new long[n+1];
        Arrays.fill(dp,-1);
        
//        long ans=numDecodingsStar(s,0,dp);
        long ans= numDecodingsStar_tabu(s,0,dp);      
        return (int)ans;
    }     
}
