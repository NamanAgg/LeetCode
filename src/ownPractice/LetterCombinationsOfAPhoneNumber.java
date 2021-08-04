//***********17. Letter Combinations of a Phone Number
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
// Return the answer in any order.
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:
// Input: digits = ""
// Output: []

// Example 3:
// Input: digits = "2"
// Output: ["a","b","c"]

// Constraints:
// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].
public class LetterCombinationsOfAPhoneNumber{
    String[] dict=new String[]{
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        letterCombination(digits,0,"",ans);
        return ans;
    }
    
    public void letterCombination(String digit,int idx,String small,List<String> ans){
        if(idx==digit.length()){
            ans.add(small);
            return;
        }
        
        int num=(int)(digit.charAt(idx)-'0');
        for(int i=0;i<dict[num].length();i++){
            letterCombination(digit,idx+1,small+dict[num].charAt(i),ans);
        }
        
    }
}