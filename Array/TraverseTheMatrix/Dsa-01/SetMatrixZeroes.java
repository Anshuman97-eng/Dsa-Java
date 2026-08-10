/*
 * Problem : Set Matrix Zeroes (LeetCode 73)
 *
 * Pattern : Matrix Traversal + Marking
 *
 * Definition:
 * If matrix[i][j] == 0,
 * make its entire row and column 0.
 *
 * Example:
 *
 * 1  1  1
 * 1  0  1
 * 1  1  1
 *
 * Output:
 *
 * 1  0  1
 * 0  0  0
 * 1  0  1
 *
 * Algorithm:
 * 1. Find all zeros.
 * 2. Mark their rows and columns.
 * 3. Make marked rows zero.
 * 4. Make marked columns zero.
 *
 * Time  : O(m × n)
 * Space : O(m + n)
 */

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Store which rows contain zero
        boolean[] zeroRow = new boolean[rows];

        // Store which columns contain zero
        boolean[] zeroCol = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            if (zeroRow[i]) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < cols; j++) {
            if (zeroCol[j]) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };

        setZeroes(matrix);

        for (int[] row : matrix) {

            for (int value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}