//*********************1061.Lexicographically Smallest Equivalent String
// Given strings A and B of the same length, we say A[i] and B[i] are equivalent characters.
// For example, if A = "abc" and B = "cde", then we have 'a' == 'c', 'b' == 'd', 'c' == 'e'.
// Equivalent characters follow the usual rules of any equivalence relation:
// Reflexivity: 'a' == 'a'
// Symmetry: 'a' == 'b' implies 'b' == 'a'
// Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'
// For example, given the equivalency information from A and B above, S = "eed", "acd",
// and "aab" are equivalent strings, and "aab" is the lexicographically smallest equivalent string of S.
// Return the lexicographically smallest equivalent string of S by using the equivalency information from A and B.

// Example 1:
// Input: A = "parker", B = "morris", S = "parser"
// Output: "makkek"
// Explanation: Based on the equivalency information in A and B, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
// The characters in each group are equivalent and sorted in lexicographical order. So the answer is "makkek".

// Example 2:
// Input: A = "hello", B = "world", S = "hold"
// Output: "hdld"
// Explanation:  Based on the equivalency information in A and B, we can group their characters as [h,w], [d,e,o], [l,r].
// So only the second letter 'o' in S is changed to 'd', the answer is "hdld".

// Example 3:
// Input: A = "leetcode", B = "programs", S = "sourcecode"
// Output: "aauaaaaada"
// Explanation:  We group the equivalent characters in A and B as [a,o,e,r,s,c], [l,p], [g,t] and [d,m],
// thus all letters in S except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".

// Note:
// String A, B and S consist of only lowercase English letters from 'a' - 'z'.
// The lengths of string A, B and S are between 1 and 1000.
// String A and B are of the same length.
public class LexicographicallySmallestEquivalentStringTwo{
    int[] par, size;

    public int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        par = new int[26];
        for (int i = 0; i < 26; i++)
            par[i] = i;

        for (int i = 0; i < s1.length(); i++) {
            int p1 = findPar(s1.charAt(i) - 'a');
            int p2 = findPar(s2.charAt(i) - 'a');

            par[p1] = Math.min(p1, p2);
            par[p2] = Math.min(p1, p2);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char ch = (char) (findPar(baseStr.charAt(i) - 'a') + 'a');
            sb.append(ch);
        }

        return sb.toString();
    }
}