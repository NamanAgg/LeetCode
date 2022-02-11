//*************567. Permutation in String
// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
// In other words, return true if one of s1's permutations is the substring of s2.

// Example 1:
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

// Example 2:
// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false

// Constraints:
// 1 <= s1.length, s2.length <= 104
// s1 and s2 consist of lowercase English letters.
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[]arr = new int[26];
        int[]myArr = new int[26];
        if(s1.length()>s2.length()) return false;
        for(Character ch : s1.toCharArray())
            arr[ch-'a']++;
        int i = 0;
        int j = 0;
        for(i=0;i<s1.length()-1;i++)
            myArr[s2.charAt(i)-'a']++;
        for(i = s1.length()-1 ; i < s2.length() ; i++){
            myArr[s2.charAt(i)-'a']++;
            if(areEqual(arr,myArr)) return true;
            myArr[s2.charAt(j)-'a']--;
            j++;
        }
        return false;
    }
    
    public boolean areEqual(int[]arr1,int[]arr2){
        for(int i=0;i<26;i++)
            if(arr1[i]!=arr2[i]) return false;
        return true;
    }
}
