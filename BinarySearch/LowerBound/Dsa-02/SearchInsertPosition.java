// Question: Search Insert Position (LeetCode 35)
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // ✅ found exact target
            } else if (nums[mid] < target) {
                low = mid + 1; // 👉 move right
            } else {
                high = mid - 1; // 👉 move left
            }
        }

        return low; // ✅ position where target should be inserted
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        System.out.println(searchInsert(nums, target)); 
        // Expected: 1 (insert at index 1)
    }
}
