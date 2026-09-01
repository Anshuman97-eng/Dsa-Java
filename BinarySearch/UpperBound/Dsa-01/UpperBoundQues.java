// Question: Upper Bound (Binary Search variation)
public class UpperBoundQues {
    public static int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            // 👉 write your binary search logic here
            int mid = low + (high - low )/2;

            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low; // ✅ placeholder: first index > target
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int target = 5;

        System.out.println(upperBound(nums, target)); 
        // Expected: 3 (nums[3] = 7 is first > 5)
    }
}
