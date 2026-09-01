public class FirstLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target); // function to find first occurrence
        int last = findLast(nums, target); // function to find last occurrence
        return new int[] { first, last };
    }

    // 👉 function to find first occurrence
    private static int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        // binary search logic here
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    // 👉 function to find last occurrence
    private static int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high-low) /2;
            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        // binary search logic here
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 3, 4 };
        int target = 2;

        int[] result = searchRange(nums, target);
        System.out.println("First = " + result[0] + ", Last = " + result[1]);
    }
}
