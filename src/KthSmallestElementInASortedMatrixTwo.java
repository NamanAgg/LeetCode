//******************378. Kth Smallest Element in a Sorted Matrix
//Given an n x n matrix where each of the rows and columns are sorted in ascending order, 
//return the kth smallest element in the matrix.
//Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
//Example 1:
//Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//Output: 13
//Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
//
//Example 2:
//Input: matrix = [[-5]], k = 1
//Output: -5
//
//Constraints:
//n == matrix.length
//n == matrix[i].length
//1 <= n <= 300
//-109 <= matrix[i][j] <= 109
//All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
//1 <= k <= n2
import java.util.*;
import java.io.*;
public class KthSmallestElementInASortedMatrixTwo {
	  public int kthSmallest(int[][] matrix, int k) {
	        int n = matrix.length, m = matrix[0].length;
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
	            return matrix[a / m][a % m] - matrix[b / m][b % m];
	        });

	        for (int i = 0; i < n; i++)
	            pq.add(i * m + 0);

	        while (--k > 0) {
	            int idx = pq.remove();
	            int r = idx / m;
	            int c = (idx % m);
	            if (c + 1 < m)
	                pq.add(r * m + c + 1);
	        }

	        int idx = pq.peek();
	        return matrix[idx / m][idx % m];
	    }
}
