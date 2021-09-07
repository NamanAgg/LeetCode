//**************3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Example 4:
// Input: s = ""
// Output: 0

// Constraints:
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int first =0; 
        int last =0;
        int maxlen =0;
        HashSet<Character>substr = new HashSet<>();
        while(last < s.length()){
            if(substr.contains(s.charAt(last)) == false){
                substr.add(s.charAt(last));
                last++;
                maxlen = Math.max(substr.size(),maxlen);
            }else{
                substr.remove(s.charAt(first));
                first++;
            }
        }
        return maxlen;
    }
}
