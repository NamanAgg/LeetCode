//************354. Russian Doll Envelopes
// You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
// One envelope can fit into another if and only if both the width and height of one envelope are greater than the other
// envelope's width and height.
// Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
// Note: You cannot rotate an envelope.

// Example 1:
// Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
// Output: 3
// Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

// Example 2:
// Input: envelopes = [[1,1],[1,1],[1,1]]
// Output: 1

// Constraints:
// 1 <= envelopes.length <= 5000
// envelopes[i].length == 2
// 1 <= wi, hi <= 104
public class RussianDollsEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        int[]dp=new int[n];
        Arrays.sort(envelopes,(a,b)->{
            return a[0]-b[0];
        });    
        int ans=0;
    
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(envelopes[j][1]<envelopes[i][1] && envelopes[j][0]<envelopes[i][0]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }    
            ans=Math.max(ans,dp[i]);
        }
        return ans;        
    }
}
