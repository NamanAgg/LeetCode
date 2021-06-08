import java.util.*;

/*Minimum Deletions to Make Character Frequencies Unique
A string s is called good if there are no two different characters in s that have the same frequency.
Given a string s, return the minimum number of characters you need to delete to make s good.
The frequency of a character in a string is the number of times it appears in the string. 
For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

Example 1:
Input: s = "aab"
Output: 0
Explanation: s is already good.

Example 2:
Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

Example 3:
Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".

Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
Constraints:
1 <= s.length <= 105
s contains only lowercase English letters.*/

public class minimumDeletionsToMakeCharacterFrequenciesUnique {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=scn.next();
		System.out.println(minDeletions(str));
		
	}
	public static int minDeletions(String s) {
		 HashMap<Integer,Integer> hmap= new HashMap<>();
		 int op=0;
		for(int i=97;i<=122;i++) {
			int count=0;
			for(int j=0;j<s.length();j++) {
				int x=s.charAt(j);
				if(i==x)
					++count;
			}
			if(count!=0) {
				while(hmap.containsValue(count)&&count!=0) {
					op++;
					count--;
				}
				hmap.put(i,count);
			}
		}
		return op;
		 
	}
	
}
