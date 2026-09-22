public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;

        while(row < n && col >= 0 ){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target ){
                col = col - 1;
            }else {
                row = row + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrixII obj = new SearchA2DMatrixII();

        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };

        int target = 5;

        boolean found = obj.searchMatrix(matrix, target);
        System.out.println("Target found? " + found);
    }
}
