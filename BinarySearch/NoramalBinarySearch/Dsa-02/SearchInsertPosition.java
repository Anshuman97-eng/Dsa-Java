// Question: Search Insert Position (LeetCode 35)
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int lower = 0, high = nums.length - 1;

        while (lower <= high) {
            // 👉 write your binary search logic here
            int mid = lower + (high - lower)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                high = mid - 1;
            }else{
                lower = mid+1;
            }
        }

        return lower; //  placeholder
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        System.out.println(searchInsert(nums, target)); // Expected: 2
    }
}
