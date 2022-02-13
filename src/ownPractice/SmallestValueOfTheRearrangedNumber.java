package ownPractice;
//****************2165. Smallest Value of the Rearranged Number
// You are given an integer num. Rearrange the digits of num such that its value is minimized and it does not contain any leading zeros.
// Return the rearranged number with minimal value.
// Note that the sign of the number does not change after rearranging the digits.

// Example 1:
// Input: num = 310
// Output: 103
// Explanation: The possible arrangements for the digits of 310 are 013, 031, 103, 130, 301, 310. 
// The arrangement with the smallest value that does not contain any leading zeros is 103.

// Example 2:
// Input: num = -7605
// Output: -7650
// Explanation: Some possible arrangements for the digits of -7605 are -7650, -6705, -5076, -0567.
// The arrangement with the smallest value that does not contain any leading zeros is -7650.

// Constraints:
// -1015 <= num <= 1015
public class SmallestValueOfTheRearrangedNumber {
    public long smallestNumber(long num) {
        int[]freq = new int[10];
        long myNum = Math.abs(num);
        while(myNum!=0){
            int digit = (int)(myNum%10);
            myNum/=10;
            freq[digit]++;
        }
        // display(freq);
        long ans = 0;
        if(num<0){
            for(int i=9;i>=0;i--){
                if(freq[i]!=0){
                    int count = freq[i];
                    while(count-->0){
                        ans = ans*10 + i;
                    }
                }
            }
            ans = -ans;
        }
        else{
            int i = 0;
            if(freq[0]!=0){
                i++;
                while(i<=9 && freq[i]==0){
                    i++;
                }
                if(i<=9){
                    int count = freq[i];
                    ans = ans*10 + i;
                    freq[i]--;
                    // i++;
                    count = freq[0];
                    while(count-->0){
                        ans = ans*10;
                    }
                }
            }
              while(i<=9){
                if(freq[i]!=0){
                    int count = freq[i];
                    while(count-->0){
                        ans = ans*10 + i;
                    }
                }
                  i++;
            }
        }
        
        return ans;
    }
    
    public void display(int[]arr){
        int i=0;
        for(Integer e : arr){
            System.out.println(i+" "+arr[i]);
            i++;
        }
    }
}
