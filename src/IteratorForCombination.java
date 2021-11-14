//****************1286. Iterator for Combination
// Design the CombinationIterator class:
// CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct
// lowercase English letters and a number combinationLength as arguments.
// next() Returns the next combination of length combinationLength in lexicographical order.
// hasNext() Returns true if and only if there exists a next combination.
 
// Example 1:
// Input
// ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
// [["abc", 2], [], [], [], [], [], []]
// Output
// [null, "ab", true, "ac", true, "bc", false]
// Explanation
// CombinationIterator itr = new CombinationIterator("abc", 2);
// itr.next();    // return "ab"
// itr.hasNext(); // return True
// itr.next();    // return "ac"
// itr.hasNext(); // return True
// itr.next();    // return "bc"
// itr.hasNext(); // return False
 
// Constraints:
// 1 <= combinationLength <= characters.length <= 15
// All the characters of characters are unique.
// At most 104 calls will be made to next and hasNext.
// It's guaranteed that all calls of the function next are valid.
public class IteratorForCombination {
    ArrayList<String> res;
    int count = -1;
    public CombinationIterator(String characters, int combinationLength) {
        res = new ArrayList<>();
        count = 0;
        StringBuilder sb = new StringBuilder();
        combinationHelper(characters,-1,combinationLength,sb);
        
    }
    
    public void combinationHelper(String str,int idx,int k,StringBuilder sb){
        if(k==0){
            res.add(sb.toString());
            return;
        }
        if(idx==str.length()) return;
        
        for(int i=idx+1;i<str.length();i++){
            sb.append(str.charAt(i));
            combinationHelper(str,i,k-1,sb);
            sb.delete(sb.length()-1,sb.length());
        }
    }
    
    public String next() {
        return res.get(count++);  
    }
    
    public boolean hasNext() {
        return count<res.size();
    }
}
