package ownPractice;
//*************85. Maximal Rectangle
// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 
// Example 1:
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.

// Example 2:
// Input: matrix = []
// Output: 0

// Example 3:
// Input: matrix = [["0"]]
// Output: 0

// Example 4:
// Input: matrix = [["1"]]
// Output: 1

// Example 5:
// Input: matrix = [["0","0"]]
// Output: 0

// Constraints:
// rows == matrix.length
// cols == matrix[i].length
// 0 <= row, cols <= 200
// matrix[i][j] is '0' or '1'.

// See this video for clearity
// [pepcoding video](https://www.youtube.com/watch?v=bgWt2qtFhbQ&t=3s//)
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        preprocessingHeightsInMatrix(matrix);
        
        int answer = Integer.MIN_VALUE;
        
        for(char[]arr: matrix)
            answer = Math.max(answer,largestAreaHistogram(arr));
        
        return answer;
    }
    
    public void preprocessingHeightsInMatrix(char[][]matrix){
        for(int i=1;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                if(matrix[i][j]=='1')
                   matrix[i][j]= (char)((matrix[i][j]-'0' + matrix[i-1][j]-'0')+'0');
    }
    
    public int largestAreaHistogram(char[]arr){
        int ans = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int i=0;
        stack.push(-1);
        while(i<=arr.length){
            int val = i==arr.length?0:(arr[i]-'0');
            while(stack.peek()!=-1 && (arr[stack.peek()]-'0')>=val){
                int rm = i; //rightMin;
                int h = arr[stack.pop()]-'0';//height;
                int lm = stack.peek();
                ans = Math.max(ans,h*(rm-lm-1));
            }
            
            stack.push(i);
            i++;
        }
        
        return ans;
    }
}
