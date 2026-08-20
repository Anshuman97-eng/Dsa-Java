package Array.Sort;

class MergeSort {

    public static void main(String[] args) {

        int[] arr = {4, 3, 5, 6};

        mergeSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {

        // Write your code here
        if(left >= right){
            return;
        }

        int mid = left + (right-left) /2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        // Write your code here
        int[] temp = new int[right-left+1];

        int i = left;
        int j = mid+1;
        int k=0;

        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= right){
            temp[k++] = arr[j++];
        }

        for(int x =0 ; x < temp.length ; x++){
            arr[left + x] = temp[x];
        }

    }
}