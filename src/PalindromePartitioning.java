//*************131. Palindrome Partitioning
// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return all possible palindrome partitioning of s.
// A palindrome string is a string that reads the same backward as forward.

// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

// Example 2:
// Input: s = "a"
// Output: [["a"]]

// Constraints:
// 1 <= s.length <= 16
// s contains only lowercase English letters.
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(s,new ArrayList<>(),ans);
        return ans;
        
    }

    private void partitionHelper(String ques,List<String> ans,List<List<String>>result){
        if(ques.length()==0){
            result.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=0;i<ques.length();i++){
            String prefix=ques.substring(0,i+1);
            if(isPalindrome(prefix)){
                String ros=ques.substring(i+1); //ros: rest of string
                ans.add(prefix);
                partitionHelper(ros,ans,result);
                ans.remove(ans.size()-1);
            }
        }
    }
    
    
    boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;
        
        while(i<j) if(str.charAt(i++)!=str.charAt(j--)) return false;
        
        return true;
    }
}
