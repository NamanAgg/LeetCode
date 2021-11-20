//*************1178. Number of Valid Words for Each Puzzle
// With respect to a given puzzle string, a word is valid if both the following conditions are satisfied:
// word contains the first letter of puzzle.
// For each letter in word, that letter is in puzzle.
// For example, if the puzzle is "abcdefg", then valid words are "faced", "cabbage", and "baggage", while
// invalid words are "beefed" (does not include 'a') and "based" (includes 's' which is not in the puzzle).
// Return an array answer, where answer[i] is the number of words in the given word list words that is valid
// with respect to the puzzle puzzles[i].
 
// Example 1:
// Input: words = ["aaaa","asas","able","ability","actt","actor","access"],
// puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
// Output: [1,1,3,2,4,0]
// Explanation: 
// 1 valid word for "aboveyz" : "aaaa" 
// 1 valid word for "abrodyz" : "aaaa"
// 3 valid words for "abslute" : "aaaa", "asas", "able"
// 2 valid words for "absoryz" : "aaaa", "asas"
// 4 valid words for "actresz" : "aaaa", "asas", "actt", "access"
// There are no valid words for "gaswxyz" cause none of the words in the list contains letter 'g'.

// Example 2:
// Input: words = ["apple","pleas","please"], puzzles = ["aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"]
// Output: [0,1,3,2,0]

// Constraints:
// 1 <= words.length <= 105
// 4 <= words[i].length <= 50
// 1 <= puzzles.length <= 104
// puzzles[i].length == 7
// words[i] and puzzles[i] consist of lowercase English letters.
// Each puzzles[i] does not contain repeated characters.
import java.util.*;
import java.io.*;
public class NumberOfValidWordsForEachPuzzle {
    List<Integer> ll;
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        ll = new ArrayList<>();
        help1(words,puzzles);
        return ll;
    }
    private void help1(String[] words,String[] puzzles)
    {
        
       HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0;i<26;i++)
        {
            map.put((char)('a'+i),new ArrayList<>());
        }
        for(String word:words)
        {
            int wmask = 0;
            for(int i = 0;i<word.length();i++)
            {
                char ch = word.charAt(i);
                wmask = wmask | 1<<(ch-'a');
            }
            HashSet<Character> set = new HashSet<>();
            for(int i = 0;i<word.length();i++)
            {
                if(!set.contains(word.charAt(i)))
                {
                    set.add(word.charAt(i));
                    map.get(word.charAt(i)).add(wmask);
                }
            }
        }
        
        for(String puzzle:puzzles)
        {
            ArrayList<Integer> al = map.get(puzzle.charAt(0));
          
            int pmask = 0;
            for(int i = 0;i<puzzle.length();i++)
            {
                char ch = puzzle.charAt(i);
                pmask = pmask | 1<<(ch-'a');
            }
         
            int count = 0;
            for(int i = 0;i<al.size();i++)
            {
                if((al.get(i) & pmask )== al.get(i))
                {
                    
                    count++;
                }
            }
            ll.add(count);
        }
    }
}

// The idea here is to first create a HashMap of Characters and ArrayList<Integer> which will map 26 characters to bit masks of all words(ArrayList) that contains this character.

// After doing this,
// We will loop through the puzzles array(also create its bitmask simultaneously) take out first character of each puzzle word and then look only in those bit-masks that are mapped against this first character.

// In order to check whether the puzzle word satisfies any word in Words array,we just perform AND (&) operation on bit masks of word and puzzle, if answer we obtain is equal to bit mask of word....we increase the count.

}
