//********First Unique Character in String.
//Given a string, find the first non-repeating character in it and return its index. 
//If it doesn't exist, return -1.
//
//Examples:
//
//s = "leetcode"
//return 0.
//
//s = "loveleetcode"
//return 2.
// 
//
//Note: You may assume the string contains only lowercase English letters.


import java.util.Scanner;
import java.util.*;
public class FirstUniqueCharacterInString {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=scn.next();
		System.out.println(firstUniqChar(s));
	}
	
	public static int firstUniqChar(String s) {
		int [] arr=new int [26];
		for(int i=0;i<s.length();i++)
			arr[s.charAt(i)-'a']++;
			
		for(int i=0;i<s.length();i++)
			if(arr[s.charAt(i)-'a']==1)
				return i;
		
		return -1;	
	}

}
