// LeetCode 37 - Sudoku Solver
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        // call your recursive function here
        solve(board,0,0);
    }   

    private boolean solve(char[][] board, int row, int col) {
        // your recursion logic here

        if(row == 9){
            return true;
        }
        
        if(col == 9){
            return solve(board, row+1, 0);
        }

        if(board[row][col] != '.'){
            return solve(board,row,col+1);
        }

        for(int i=1 ; i<=9 ; i++){
            char ch = (char)(i + '0');
            if(isSafe(board, row, col, ch)){
                board[row][col] = (char)(i + '0');
                if(solve(board,row,col+1)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char ch) {
        // your row, col, and 3x3 grid check here
        
        // check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == ch) return false;
        }

        // check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) return false;
        }


        int findRow = (row/3) * 3;
        int findCol = (col/3) * 3;
        for(int i= findRow ; i<findRow+3 ; i++){
            for(int j= findCol ; j<findCol+3 ; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        solver.solveSudoku(board);

        // print board after solving
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
