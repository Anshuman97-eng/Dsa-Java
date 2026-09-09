// LeetCode 52 - N-Queens II (Hard)
import java.util.*;

public class NQueensII {
    private int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backTrack(board, 0, n);   // recursion call
        return count;
    }

    // recursion method (you fill logic)
    private void backTrack(char[][] board, int row, int n) {
        if (row == n) {
            count++;   // ✅ increment when full solution found
            return;
        }

        for(int i=0 ; i<n ; i++){
            if(isSafe(board, row, i, n)){
                board[row][i] = 'Q';
                backTrack(board, row+1, n);
                board[row][i] = '.';
            }
        }
    }

    // isSafe method (you fill logic)
    private boolean isSafe(char[][] board, int row, int col, int n) {
        for(int i=0 ; i<row ; i++){
            if(board[i][col] == 'Q'){
                return  false;
            }
        }

        for(int i=row-1,j=col-1 ; i>=0 && j>=0 ; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=row-1,j=col+1 ; i>=0 && j<n ; i--,j++){
            if(board[i][j] == 'Q'){
                return  false;
            }
        }
        return true;
    }

    // main method to test
    public static void main(String[] args) {
        NQueensII solver = new NQueensII();
        int n = 4; // you can change this
        int solutions = solver.totalNQueens(n);
        System.out.println("Number of solutions for " + n + "-Queens: " + solutions);
    }
}
