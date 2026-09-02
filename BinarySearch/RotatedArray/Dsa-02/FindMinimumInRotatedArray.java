public class FindMinimumInRotatedArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] <= nums[high]){
                high =  mid;
            }else{
                low = mid + 1;
            }
            // 👉 write your if-else logic here
        }

        return nums[low];
        // 👉 return the minimum element
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int result = findMin(nums);
        System.out.println("Minimum = " + result);
    }
}
