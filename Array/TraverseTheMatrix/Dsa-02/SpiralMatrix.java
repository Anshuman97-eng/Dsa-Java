import java.util.ArrayList;
import java.util.List;

/*
 * Problem : Spiral Matrix (LeetCode 54)
 *
 * Pattern : Matrix Traversal + Four Boundaries
 *
 * Definition:
 * Return all matrix elements in spiral order.
 *
 * Example:
 *
 * 1  2  3
 * 4  5  6
 * 7  8  9
 *
 * Output:
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * Algorithm:
 * 1. Start with four boundaries.
// Move right
// Move down
// Move left
// Move up
 * 6. Shrink the boundaries.
 *
 * Boundaries:
 * top
 * bottom
 * left
 * right
 *
 * Time  : O(m × n)
 * Space : O(m × n) for the output list
 */

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // Your code here
        while (top <= bottom && left <= right) {

            //  Right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            //  Down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            //  Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //  Up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        List<Integer> result = spiralOrder(matrix);

        System.out.println(result);
    }
}