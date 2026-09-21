public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int right = m*n - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            int row = mid / m;
            int col = mid % m;
            int val = matrix[row][col];

            if(val == target){
                return  true;
            }else if(val > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix obj = new SearchA2DMatrix();

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 16;

        boolean found = obj.searchMatrix(matrix, target);
        System.out.println("Target found? " + found);
    }
}
