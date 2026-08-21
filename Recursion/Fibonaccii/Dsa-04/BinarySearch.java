public class BinarySearch {

    static int binarySearch(int[] arr, int left, int right, int target) {

        // Recursion logic here
        if(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target ){
                return target;
            }

            if(arr[mid] < target){
                return binarySearch(arr, mid+1, right, target);
            }else{
                return binarySearch(arr, left, mid-1, target);
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 5;

        System.out.println(
            binarySearch(arr, 0, arr.length - 1, target)
        );
    }
}