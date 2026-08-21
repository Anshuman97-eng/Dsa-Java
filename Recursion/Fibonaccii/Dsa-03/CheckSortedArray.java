public class CheckSortedArray {

    static boolean isSorted(int[] arr, int index) {

        // Recursion logic here
        if(index == 1 || index == 0)
        {
            return true;
        }


        return arr[index-1] >= arr[index-2] && isSorted(arr, index-1);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(isSorted(arr, arr.length));
    }
}