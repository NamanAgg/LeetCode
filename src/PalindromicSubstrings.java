//***********647. Palindromic Substrings
// Given a string s, return the number of palindromic substrings in it.
// A string is a palindrome when it reads the same backward as forward.
// A substring is a contiguous sequence of characters within the string.

// Example 1:
// Input: s = "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".

// Example 2:
// Input: s = "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

// Constraints:
// 1 <= s.length <= 1000
// s consists of lowercase English letters.
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        boolean[][]dp = isPalindrome(s);
        
        int count = 0;
        for(boolean []d : dp)
            for(Boolean e : d)
                if(e) count+=1;
        
        return count;
    }
    
    public boolean[][] isPalindrome(String s){
          int n = s.length();
        boolean[][] isPlaindromeDp = new boolean[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    isPlaindromeDp[i][j] = true;
                else if (gap == 1 && s.charAt(i) == s.charAt(j))
                    isPlaindromeDp[i][j] = true;
                else
                    isPlaindromeDp[i][j] = s.charAt(i) == s.charAt(j) && isPlaindromeDp[i + 1][j - 1];
            }
        }
        
        return isPlaindromeDp;
    }
}
