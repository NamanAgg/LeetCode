//************1081. Smallest Subsequence of Distinct Characters
// Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

// Example 1:
// Input: s = "bcabc"
// Output: "abc"

// Example 2:
// Input: s = "cbacdcbc"
// Output: "acdb"

// Constraints:
// 1 <= s.length <= 1000
// s consists of lowercase English letters.

// Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {
        return removeDuplicateLetters(s);  
      }
       public String removeDuplicateLetters(String s) {
          int[]freq = new int[26];
          boolean[] used = new boolean[26];
          calculateFreqInString(s,freq);
          Stack<Character> stack = new Stack<>();
          int i=0;
          for(i=0;i<s.length();i++){
              char ch = s.charAt(i);
              if(used[ch-'a']){
                  freq[ch-'a']-=1; 
                  continue;
              }
              if(stack.isEmpty() || stack.peek()<ch){
                  stack.push(ch);
                  used[ch-'a'] = true;
                  freq[ch-'a']-=1;
              }
              else{
                  if(freq[stack.peek()-'a']>0){
                      char rm = stack.pop();
                      used[rm-'a'] = false;
                      i-=1;
                  }
                  else{
                      stack.push(ch);
                      freq[ch-'a']-=1;
                      used[ch-'a'] = true;
                  }
              }
          }
          StringBuilder sb = new StringBuilder();
          while(stack.size()!=0) sb.append(stack.pop());
          
          return sb.reverse().toString();
      }
      
      public void calculateFreqInString(String s,int[]freq){
          for(int i=0;i<s.length();i++)
              freq[s.charAt(i)-'a']+=1;
          
      }
}
