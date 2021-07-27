//***************8990. Satisfiability of Equality Equations
// Given an array equations of strings that represent relationships between variables,
// each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".
//  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
// Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.

// Example 1:
// Input: ["a==b","b!=a"]
// Output: false
// Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
//  There is no way to assign the variables to satisfy both equations.

// Example 2:
// Input: ["b==a","a==b"]
// Output: true
// Explanation: We could assign a = 1 and b = 1 to satisfy both equations.

// Example 3:
// Input: ["a==b","b==c","a==c"]
// Output: true

// Example 4:
// Input: ["a==b","b!=c","c==a"]
// Output: false

// Example 5:
// Input: ["c==c","b==d","x!=z"]
// Output: true
 
// Note:
// 1 <= equations.length <= 500
// equations[i].length == 4
// equations[i][0] and equations[i][3] are lowercase letters
// equations[i][1] is either '=' or '!'
// equations[i][2] is '='
public class SatisfiabilityOfEqualityEquationsTwo{
    int[] par, size;
    public int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    public boolean equationsPossible(String[] equations) {
        par = new int[26];
        for (int i = 0; i < 26; i++)
            par[i] = i;

        for (String s : equations) {
            char ch1 = s.charAt(0), ch2 = s.charAt(1), ch3 = s.charAt(3);
            int p1 = findPar(ch1 - 'a');
            int p2 = findPar(ch3 - 'a');
            if (ch2 == '=' && p1 != p2) 
                par[p1] = p2;
        }
        for (String s : equations) {
            char ch1 = s.charAt(0), ch2 = s.charAt(1), ch3 = s.charAt(3);
            int p1 = findPar(ch1 - 'a');
            int p2 = findPar(ch3 - 'a');
            if (ch2 == '!' && p1 == p2) 
                return false;
        }
        return true;
    }
}