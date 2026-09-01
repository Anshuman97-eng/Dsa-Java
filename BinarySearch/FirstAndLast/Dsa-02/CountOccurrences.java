public class CountOccurrences {
    public static int countOccurrences(int[] nums, int target) {
        int lower = lowerBound(nums, target);   // first index ≥ target
        int upper = upperBound(nums, target);   // first index > target
        return upper - lower;                   // total count
    }

    // 👉 function to find lower bound
    private static int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = 0;

        // binary search logic here

        while(low <= high ){
            int mid = low + (high - low)/2;
            if(nums[mid] <= target){
                ans = mid;
               high = mid - 1; 
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    // 👉 function to find upper bound
    private static int upperBound(int[] nums, int target) {
        int ans = 0;
        int low = 0;
        int high = nums.length - 1;

        // binary search logic here
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4};
        int target = 2;

        int result = countOccurrences(nums, target);
        System.out.println("Count = " + result);
    }
}
