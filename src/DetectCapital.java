//*************520. Detect Capital
// We define the usage of capitals in a word to be right when one of the following cases holds:
// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Given a string word, return true if the usage of capitals in it is right.

// Example 1:
// Input: word = "USA"
// Output: true

// Example 2:
// Input: word = "FlaG"
// Output: false

// Constraints:
// 1 <= word.length <= 100
// word consists of lowercase and uppercase English letters.
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int countCapitalAlphabets = 0;
              for(Character ch : word.toCharArray()){
                  int val = ch-'A';
                  if(val>=0 && val<=25) countCapitalAlphabets++;
              }
              
              if(countCapitalAlphabets==0 || countCapitalAlphabets==word.length() || (countCapitalAlphabets==1 && (word.charAt(0)-'A')>=0 && (word.charAt(0)-'A')<26)) return true;
              return false;
          }
}
