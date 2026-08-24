public class RotatedArraySearch {
    static int search(int[] nums, int target, int low, int high) {
        if(low > high){
            return -1;
        }
        int mid = (low + high) / 2;

        if (nums[mid] == target)
            return mid;

        // Check if left half is sorted
        if (nums[low] <= nums[mid]) {
            if (target >= nums[low] && target < nums[mid]) {
                return search(nums, target, low, mid - 1);
            } else {
                return search(nums, target, mid + 1, high);
            }
        }
        // Else right half is sorted
        else {
            if (target > nums[mid] && target <= nums[high]) {
                return search(nums, target, mid + 1, high);
            } else {
                return search(nums, target, low, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 1;
        int idx = search(arr, target, 0, arr.length - 1);
        System.out.println("Found at index: " + idx);
    }
}
