//*********37. Sudoku Solver
// Write a program to solve a Sudoku puzzle by filling the empty cells.
// A sudoku solution must satisfy all of the following rules:
// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.

// Example 1:
// Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
// Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
// Explanation: The input board is shown above and the only valid solution is shown below:

// Constraints:
// board.length == 9
// board[i].length == 9
// board[i][j] is a digit or '.'.
// It is guaranteed that the input board has only one solution.
public class SudokuSolverTwo{
    public boolean isSafeToPlaceNumber(char[][] board, int row, int col, int num) {

        int n = board.length, m = board[0].length;
        // row
        for (int j = 0; j < m; j++)
            if ((board[row][j] - '0') == num)
                return false;

        // col
        for (int i = 0; i < n; i++)
            if ((board[i][col] - '0') == num)
                return false;

        // mat
        row = (row / 3) * 3;
        col = (col / 3) * 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if ((board[i + row][j + col] - '0') == num)
                    return false;

        return true;
    }

    public void solveSudoku(char[][] board) {
         sudokuSolver(board, 0);
    
    }
     public boolean sudokuSolver(char[][] board, int idx) {
        if (idx == 81) {
            return true;
        }

        int r = idx / 9;
        int c = idx % 9;

        if (board[r][c] != '.') {
            if (sudokuSolver(board, idx + 1))
                return true;
        } else {
            for (int num = 1; num <= 9; num++) {
                if (isSafeToPlaceNumber(board, r, c, num)) {
                    board[r][c] = (char) (num + '0');
                    if (sudokuSolver(board, idx + 1))
                        return true;
                    board[r][c] = '.';
                }
            }
        }

        return false;
    }
}