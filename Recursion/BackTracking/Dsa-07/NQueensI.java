// LeetCode 51 - N-Queens (Hard)
import java.util.*;

public class NQueensI {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0 ; i<n ; i++){
            Arrays.fill(board[i],'.' );
        }
        backTrack(board, 0, n, result);

        return result;
    }

    // recursion method (you fill logic)
    private void backTrack(char[][] board, int row, int n, List<List<String>> result) {
        if(row == n){
           List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            result.add(temp);
        }

        for(int i=0 ; i<n ; i++){
            if(isSafe(board, row, i, n)){
                board[row][i] = 'Q';
                backTrack(board, row+1, n, result);
                board[row][i] = '.';
            }
        }
    }

    // isSafe method (you fill logic)
    private boolean isSafe(char[][] board, int row, int col, int n) {

        for(int i=0 ; i<row ; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i=row-1,j=col-1 ; i>=0 && j>=0 ; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=row-1,j=col+1 ; i>=0 && j<n ; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }


        return true;
    }

    // main method to test
    public static void main(String[] args) {
        NQueensI solver = new NQueensI();
        int n = 4; // you can change this
        List<List<String>> solutions = solver.solveNQueens(n);

        System.out.println("Number of solutions for " + n + "-Queens: " + solutions.size());
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
