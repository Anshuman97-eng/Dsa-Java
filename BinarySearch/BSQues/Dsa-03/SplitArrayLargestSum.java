public class SplitArrayLargestSum {
    // Function to check if we can split into <= m subarrays
    private boolean canSplit(int[] nums, int m, int maxSum) {
        // 👉 You will write the greedy check logic here
        int day = 1;
        int max = 0;

        for(int n : nums){
            if(max + n > maxSum){
                day++;
                max = 0;
            }
            max += n;
        }
        return day <= m; // placeholder return
    }

    // Main function: binary search on answer
    public int splitArray(int[] nums, int m) {
        // 👉 You will write the binary search logic here
        int low = 0;
        int high = 0;

        for(int n : nums){
            low = Math.max(low, n);
            high += n;
        }

        while(low < high){
            int mid = low + (high - low)/2;

            if(canSplit(nums, m, mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low; // placeholder return
    }

    // Test the code
    public static void main(String[] args) {
        SplitArrayLargestSum sol = new SplitArrayLargestSum();
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        System.out.println(sol.splitArray(nums, m)); 
        // Expected output: 18
    }
}
