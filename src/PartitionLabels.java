//****************763. Partition Labels
// You are given a string s. We want to partition the string into as many parts as possible so that each letter
// appears in at most one part.
// Return a list of integers representing the size of these parts.

// Example 1:
// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

// Example 2:
// Input: s = "eccbbbbdec"
// Output: [10]

// Constraints:
// 1 <= s.length <= 500
// s consists of lowercase English letters.
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>(); //will store the idx of  char lastPresent
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),i);
        
       List<Integer> res = new ArrayList<>();
        int ans=0;
        int maxImpact=-1;
        for(int i=0;i<s.length();i++){
            int impactOfCurrChar = map.get(s.charAt(i));
            if(impactOfCurrChar>maxImpact)
                    maxImpact=impactOfCurrChar;
            ans++;
            if(maxImpact==i && impactOfCurrChar==i){
                res.add(ans);
                ans=0;
                maxImpact=-1;
            }
        }
        
        return res;
        
        
        
    }
}
