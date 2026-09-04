public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {   // ✅ correct condition
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;   // slope up → go right
            } else {
                high = mid;      // slope down → go left (include mid)
            }
        }

        return low; // peak index
    }

    public static void main(String[] args) {
        FindPeakElement sol = new FindPeakElement();
        int[] nums = {1, 2, 3, 1};
        System.out.println(sol.findPeakElement(nums)); 
        // Output: 2 ✅
    }
}
