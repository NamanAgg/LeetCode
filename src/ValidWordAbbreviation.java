//************408. Valid Word Abbreviation
// Given a non-empty string word and an abbreviation abbr, return whether the string matches with the given abbreviation.
// A string such as "word" contains only the following valid abbreviations:
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
// Where 1 means one character is omitted, 2 means two characters are omitted, and so on.
// Notice that only the above abbreviations are valid abbreviations of the string word.
// Any other string is not a valid abbreviation of word.

// Example 1:
// Input : s = "internationalization", abbr = "i12iz4n"
// Output : true

// Example 2:
// Input : s = "apple", abbr = "a2e"
// Output : false
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        char[]arr1 = word.toCharArray();
        char[]arr2 = abbr.toCharArray();
        int i=0;
        int j = 0;

        if(arr2.length>arr1.length) 
            return false;

        while(j<arr2.length){
            // System.out.println(i+" "+j+" "+val);
            if(arr2[j]==arr1[i]){
                j++;
                i++;
            }
            else if(arr2[j]>='0' && arr2[j]<='9'){
                int val = 0;
                while(j<arr2.length && arr2[j]>='0' && arr2[j]<='9'){
                    val*=10;
                    val+= arr2[j]-'0';
                    j++;
                }
                i+=val;
            }
            else return false;
        }

        return i==arr1.length?true:false;
    }
}
