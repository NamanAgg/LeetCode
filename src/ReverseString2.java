//******REVERSE STRING II
/*Given a string and an integer k, you need to reverse the first k characters for every 2k characters 
 counting from the start of the string. If there are less than k characters left, 
 reverse all of them.If there are less than 2k but greater than or equal to k characters, 
 then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]*/

import java.util.Scanner;
import java.util.*;
public class ReverseString2 {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=scn.next();
		int k=scn.nextInt();
		System.out.println(reverseString(s,k));

	}
	
	public static String reverseString(String s,int k) {
		if(k==0||k==1||s.length()<=1)
			return s;
		
		StringBuilder sb=new StringBuilder(s);
		int i=0;
		int len=s.length();
		while(i<len) {
			if(k+i-1<len) {
				swapOp(sb,i,k+i-1);
				//System.out.println(sb);
			}
			else {
				swapOp(sb,i,len-1);
				//System.out.println(sb);
			}
			i+=2*k;
		}
		
		return sb.toString();
		
	}
	
	public static void swapOp(StringBuilder sb,int i,int j) {
		while(i<j) {
			char ch=sb.charAt(i);
			char ch2=sb.charAt(j);
			
			sb.deleteCharAt(i);
			sb.insert(i, ch2);
			
			sb.deleteCharAt(j);
			sb.insert(j, ch);
			
			i++;
			j--;
		}
		
		//sb.rep
	}

}
