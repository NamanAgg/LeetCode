//******************925. Long Pressed Name
// Your friend is typing his name into a keyboard. Sometimes, when typing a character c,
// the key might get long pressed, and the character will be typed 1 or more times.
// You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name,
// with some characters (possibly none) being long pressed.

// Example 1:
// Input: name = "alex", typed = "aaleex"
// Output: true
// Explanation: 'a' and 'e' in 'alex' were long pressed.

// Example 2:
// Input: name = "saeed", typed = "ssaaedd"
// Output: false
// Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

// Example 3:
// Input: name = "leelee", typed = "lleeelee"
// Output: true

// Example 4:
// Input: name = "laiden", typed = "laiden"
// Output: true
// Explanation: It's not necessary to long press any character.

// Constraints:
// 1 <= name.length <= 1000
// 1 <= typed.length <= 1000
// name and typed contain only lowercase English letters.
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int n=name.length(),m=typed.length();
        if(n>m) return false;
        
        int i=0; //for name
        int j=0; //for typed
        while(j<m){
            if(i<n && name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            else if(i-1>=0 && i-1<n && name.charAt(i-1)==typed.charAt(j))
                j++;
            
            else 
                return false;
        }
         
        return i==n&&j==m;
    }
}
