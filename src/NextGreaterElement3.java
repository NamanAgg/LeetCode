//*************556. Next Greater Element III
// Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n
// and is greater in value than n. If no such positive integer exists, return -1.
// Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer,
// return -1.

// Example 1:
// Input: n = 12
// Output: 21

// Example 2:
// Input: n = 21
// Output: -1
 
// Constraints:
// 1 <= n <= 231 - 1
public class NextGreaterElement3 {
    public int nextGreaterElement(int n) {
        if(n < 10) return -1;
        String nextNum = nextGreaterElement_("" + n);
        long num = Long.parseLong(nextNum);
        if(num <= Integer.MAX_VALUE) {
            return (int)num;
        } else {
            return -1;
        }
    }

    private static int dipIndex(char[] arr) {
        int indx = -1;
        for(int i = arr.length - 1; i > 0; i--) {
            if(arr[i - 1] < arr[i]) {
                indx = i - 1;
                break;
            }
        }
        return indx;
    }

    private static int ceilIndex(char[] arr, int indx) {
        // indx -> dip indx
        int dipVal = arr[indx];
        int i = arr.length - 1;
        while(dipVal >= arr[i]) {
            i--;
        }
        return i;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int left, int right) {
        while(left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static String nextGreaterElement_(String str) {
        char[] arr = str.toCharArray();
        int dipIndx = dipIndex(arr);
        if(dipIndx == -1) {
            return "-1";
        }
        int ceilIndx = ceilIndex(arr, dipIndx);
        swap(arr, dipIndx, ceilIndx);
        reverse(arr, dipIndx + 1, arr.length - 1);
        return String.valueOf(arr);
    }
}
