public class Subsets {

    public static void printSubsets(int[] arr, int index, String subset) {

        // Base case
        if(index == arr.length){
            System.out.println(subset);
            return;
        }


        // Take the element
        printSubsets(arr, index+1, subset + arr[index] + " " );

        // Skip the element
        printSubsets(arr, index + 1, subset);

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        printSubsets(arr, 0, "");
    }
}

