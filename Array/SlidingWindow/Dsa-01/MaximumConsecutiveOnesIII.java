// Sliding Window Pattern (Maximum Consecutive Ones III)

public class MaximumConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {

        // Initialize variables
        int left = 0;
        int zeros = 0;
        int longest = 0;

        // Expand the window
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            // Update condition
            // Shrink the window if invalid
            while (zeros > k) {

                if (nums[left] == 0) {
                    zeros--;
                }
                // Update condition

                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }

    public static void main(String[] args) {
        int []nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        int result = longestOnes(nums, k);

        System.out.println(result);
    }
}