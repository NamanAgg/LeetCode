package ownPractice;
//*********844. Backspace String Compare
// Given two strings s and t, return true if they are equal when both are typed into empty text editors.
// '#' means a backspace character.
// Note that after backspacing an empty text, the text will continue empty.

// Example 1:
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

// Example 2:
// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".

// Example 3:
// Input: s = "a##c", t = "#a#c"
// Output: true
// Explanation: Both s and t become "c".

// Example 4:
// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

// Constraints:
// 1 <= s.length, t.length <= 200
// s and t only contain lowercase letters and '#' characters.
 
// Follow up: Can you solve it in O(n) time and O(1) space?
public class BackspaceStringCompare {
    //this question can be easily solved using stacks but that will take O(N) space
    //but this solution is O(N) time and O(1) space.
   public boolean backspaceCompare(String s, String t) {
    int i=s.length()-1;
    int j = t.length()-1;
    
    while(i>=0 && j>=0){
        if(s.charAt(i) == t.charAt(j) && s.charAt(i)!='#'){ //if characters are equal
            i--;
            j--;
        }
        
        else if(s.charAt(i)=='#'){ //if character in s is equal to #
            int count  = 0;
            while(i>=0 && s.charAt(i)=='#'){ //loop to count consecutive #
                count++;
                i--;
            }
            
            while(count>0){ //loop to remove characters from the Hashe(s) we had  
                if(i>=0 && s.charAt(i)=='#') count++;//if we counter an inbetween # while removing charcters
                else count--;
                
                i--;
            }
        }
        
        else if(t.charAt(j)=='#'){//if character in t is equal to #
            int count  = 0;
            while(j>=0 && t.charAt(j)=='#'){//loop to count consecutive #
                count++;
                j--;
            }
            
            while(count>0){//loop to remove characters from the Hashe(s) we had 
                if(j>=0 && t.charAt(j)=='#') count++;//if we counter an inbetween # while removing charcters
                else count--;
            
                j--;    
            }
        }
        
        else return false;
    }
    
    
    while(i>=0){//this loop to for the remaining character if left in s
        if(s.charAt(i)=='#'){//if character in s is equal to #
            int count  = 0;
            while(i>=0 && s.charAt(i)=='#'){//loop to count consecutive #
                count++;
                i--;
            }
            
            while(count>0){//loop to remove characters from the Hashe(s) we had 
                if(i>=0 && s.charAt(i)=='#') count++;//if we counter an inbetween # while removing charcters
                else count--;
                i--;                    
            }
        }
        
        else return false;
    }
    

    while(j>=0){ //this loop to for the remaining character if left in j
        if(t.charAt(j)=='#'){//if character in t is equal to #
            int count  = 0;
            while(j>=0 && t.charAt(j)=='#'){//loop to count consecutive #
                count++;
                j--;
            }
            
            while(count>0){//loop to remove characters from the Hashe(s) we had 
                if(j>=0 && t.charAt(j)=='#') count++;//if we counter an inbetween # while removing charcters
                else count--;
                
                j--;
            }
        }
        
        else return false;
    }
    
    return true;
}
}
