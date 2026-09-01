// Question: Lower Bound (Binary Search variation)
class LowerBound {
    public static int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            // 👉 write your binary search logic here
            int mid = low + (high - low)/2;

            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            
        }

        return low; // ✅ placeholder: first index ≥ target
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int target = 4;

        System.out.println(lowerBound(nums, target)); 
        // Expected: 2 (nums[2] = 5 is first ≥ 4)
    }
}
