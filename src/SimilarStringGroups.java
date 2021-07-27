//*****************839. Similar String Groups
// Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
// Also two strings X and Y are similar if they are equal.
// For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar,
// but "star" is not similar to "tars", "rats", or "arts".
// Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.
//  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
// We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?

// Example 1:
// Input: strs = ["tars","rats","arts","star"]
// Output: 2

// Example 2:
// Input: strs = ["omv","ovm"]
// Output: 1

// Constraints:
// 1 <= strs.length <= 300
// 1 <= strs[i].length <= 300
// strs[i] consists of lowercase letters only.
// All words in strs have the same length and are anagrams of each other.
import java.util.*;
import java.io.*;
public class SimilarStringGroups{
    int[] par, size;

    public int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    
    public boolean isSimilar(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && ++count > 2)
                return false;
        }

        return true;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length, group = n;
        par = new int[n];
        for (int i = 0; i < n; i++)
            par[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    int p1 = findPar(i);
                    int p2 = findPar(j);

                    if (p1 != p2) {
                        par[p1] = p2;
                        group--;
                    }
                }
            }
        }

        return group;
    }
    
    public static void main(String[]args) {
    	Scanner scn=new Scanner(System.in);
    	int n=scn.nextInt();
    	System.out.println(n);
    }
    
}