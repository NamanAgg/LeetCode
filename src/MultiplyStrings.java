//************43. Multiply Strings
// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
// also represented as a string.
// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

// Example 1:
// Input: num1 = "2", num2 = "3"
// Output: "6"

// Example 2:
// Input: num1 = "123", num2 = "456"
// Output: "56088"

// Constraints:
// 1 <= num1.length, num2.length <= 200
// num1 and num2 consist of digits only.
// Both num1 and num2 do not contain any leading zero, except the number 0 itself.
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n= num1.length(),m = num2.length();
        //these are base cases.
        if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2))return "0";
        if ("1".equals(num1))return num2;
        if ("1".equals(num2))return num1;
        
        //this is the array that will store the actual result 
        //the length of this array is n+m bcz when we multiply two numbers then
        //if n is the total number of digits in num1 and m is the total number of digits in num2 and
        //if k is the total number of digits in product then k<=n+m
        int[]arr = new int[n+m];
        
        //main logic
        for(int i=n-1;i>=0;i--){
            int n1 = num1.charAt(i)-'0';
            int carry = 0;
            int idx = n-i-1;
            for(int j=m-1;j>=0;j--){
                int n2 = num2.charAt(j)-'0';
                int prod = n1*n2+carry;
                carry = prod/10;
                int re = prod%10;
                arr[idx]+=re;
                if(arr[idx]>=10){
                    int val = arr[idx];
                    arr[idx] = val%10;
                    arr[idx+1] += val/10;
                }
                idx++;
            }
            while(carry!=0){
                arr[idx]+=carry%10;
                carry/=10;
                idx++;
            }
        }
        
        //this will convert the res array into string
        return convertArrayToString(arr);        
    }
    
    public String convertArrayToString(int[]arr){
        StringBuilder sb = new StringBuilder();
        int i= arr.length-1;
        for(i=arr.length-1;i>=0;i--){
            if(arr[i]!=0) break;
        }

        while(i>=0)
            sb.append(Integer.toString(arr[i--]));
           
        return sb.toString();
    }
}
