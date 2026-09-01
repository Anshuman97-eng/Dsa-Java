// Question: Count Occurrences using Lower + Upper Bound
public class CountOccurrences {

    public static int lowerBound(int[] nums ,int target){
        int low = 0 ;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high-low) /2;
            if(nums[mid] >= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    public static int upperBound(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low +(high - low)/2;

            if(nums[mid] <= target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countOccurrences(int[] nums, int target) {
        int lower = lowerBound(nums, target);   // first index ≥ target
        int upper = upperBound(nums, target);   // first index > target
        return upper - lower;                   // total count of target
    }

    // 👉 assume you already coded lowerBound() and upperBound()
    // just call them here
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4};
        int target = 2;

        System.out.println(countOccurrences(nums, target));
        // Expected: 3
    }
}
