public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        // 👉 You will write the binary search logic here
        int low = 0;
        int high = arr.length - 1;

        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] < arr[mid + 1]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low; // placeholder return
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray sol = new PeakIndexInMountainArray();
        int[] arr = {0, 2, 4, 3, 1};
        System.out.println(sol.peakIndexInMountainArray(arr)); 
        // Expected output: 2 (index of peak element)
    }
}
