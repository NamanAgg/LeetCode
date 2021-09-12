//*************345. Reverse Vowels of a String
// Given a string s, reverse only all the vowels in the string and return it.
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

// Example 1:
// Input: s = "hello"
// Output: "holle"

// Example 2:
// Input: s = "leetcode"
// Output: "leotcede"

// Constraints:
// 1 <= s.length <= 3 * 105
// s consist of printable ASCII characters.
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[]arr= s.toCharArray();
        
        for(Character e : arr)
            System.out.print(e);
        System.out.println();
        int i=0;
        int j=arr.length-1;
        
        while(i<j){
            while(i<j && !isVowel(arr,i))
                i++;
            
            while(i<j && !isVowel(arr,j))
                j--;
            
            
            if(i<j){
                char ch = arr[i];
                arr[i]=arr[j];
                arr[j]=ch;
                i++;
                j--;
            }
        }
        
        return String.valueOf(arr);
        
    }
    
    public boolean isVowel(char[]arr,int i){
        if(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u' || arr[i]=='A' || arr[i]=='E' || arr[i]=='I' || arr[i]=='O' || arr[i]=='U')
            return true;
        return false;
    }    
}