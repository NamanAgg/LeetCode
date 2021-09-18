package ownPractice;
//****************670. Maximum Swap
// You are given an integer num. You can swap two digits at most once to get the maximum valued number.
// Return the maximum valued number you can get.

// Example 1:
// Input: num = 2736
// Output: 7236
// Explanation: Swap the number 2 and the number 7.

// Example 2:
// Input: num = 9973
// Output: 9973
// Explanation: No swap.

// Constraints:
// 0 <= num <= 108
public class MaximumSwap {
    public int maximumSwap(int num) {
        String str=String.valueOf(num);
        System.out.println(str);
        char[]arr= str.toCharArray();
        String ans = getMaximum(arr);
        System.out.println(ans);
        // String cmp = String.valueOf(Integer.MAX_VALUE);
        // if(ans)
        int res= Integer.parseInt(ans);
        return res;
    }
    
    public String getMaximum(char[]arr){
        int n=arr.length;
        int[]digit=new int[10];
        Arrays.fill(digit,-1);
        
        for(int i=0;i<n;i++){
            int dig=arr[i]-'0';
            digit[dig]=i;
        }
        
        for(int i = 0;i<n;i++){
            int endRange=arr[i]-'0';
            for(int j=9;j>endRange;j--)
                if(digit[j]>i){
                    swap(arr,i,digit[j]);
                    return String.valueOf(arr);
                }
        }
        
        return String.valueOf(arr);
    }
    
    public void swap(char[]arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
