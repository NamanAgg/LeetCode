//***************1837. Sum of Digits in Base K
// Given an integer n (in base 10) and a base k, return the sum of the digits of n after converting n from base 10 to base k.
// After converting, each digit should be interpreted as a base 10 number, and the sum should be returned in base 10.

// Example 1:
// Input: n = 34, k = 6
// Output: 9
// Explanation: 34 (base 10) expressed in base 6 is 54. 5 + 4 = 9.

// Example 2:
// Input: n = 10, k = 10
// Output: 1
// Explanation: n is already in base 10. 1 + 0 = 1.

// Constraints:
// 1 <= n <= 100
// 2 <= k <= 10
public class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {
     
        if(k==10) return sumOfDig(String.valueOf(n));
        
         String res = "";
        while (n > 0){
            res += reVal(n % k);
            n /= k;
        }
        return sumOfDig(reverse(res));
    }
    public String reverse(String res){
        char[]arr=res.toCharArray();
        int i=0,j=arr.length-1;
        while(i<j){
            char temp=arr[i];
            arr[i++]=arr[j];
            arr[j--]=temp;
        }
        
        return String.valueOf(arr);
    }
    public char reVal(int num){
        if (num >= 0 && num <= 9)
            return(char)(num + '0');

        return(char)(num - 10 + 'A');
    }
    
    public int sumOfDig(String n){
        int sum=0;
        for(int i = 0;i<n.length();i++)
            sum+=(n.charAt(i)-'0');
        
        return sum;
    }    
}