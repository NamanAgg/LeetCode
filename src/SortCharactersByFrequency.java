//******************451. Sort Characters By Frequency
// Given a string s, sort it in decreasing order based on the frequency of the characters.
// The frequency of a character is the number of times it appears in the string.
// Return the sorted string. If there are multiple answers, return any of them.

// Example 1:
// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

// Example 2:
// Input: s = "cccaaa"
// Output: "aaaccc"
// Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
// Note that "cacaca" is incorrect, as the same characters must be together.

// Example 3:
// Input: s = "Aabb"
// Output: "bbAa"
// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.

// Constraints:
// 1 <= s.length <= 5 * 105
// s consists of uppercase and lowercase English letters and digits.
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if(s.length()<=2) return s;
        HashMap<Character,Integer>freq = new HashMap<>();
        for(int i=0;i<s.length();i++)
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);
        
        freq = sortByValue(freq);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> lhmap : freq.entrySet()){
            int val = lhmap.getValue();
            char key = lhmap.getKey();
            while(val-->0)
                sb.append(""+key);
        }
        return sb.toString();
    }
    
     public HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        List<Map.Entry<Character, Integer> > list =new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,Map.Entry<Character, Integer> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
