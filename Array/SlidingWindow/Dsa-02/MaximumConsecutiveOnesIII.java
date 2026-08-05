// Pattern: Sliding Window
// Question: Maximum Consecutive Ones III
//
// Explanation:
// Given a binary array,
// you can flip at most k zeros into 1's.
//
// Find the longest consecutive
// sequence of 1's.

public class MaximumConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {

        // Initialize variables
        int left = 0;
        int zeros = 0;
        int longest = 0;

        // Expand the window
        for (int right = 0; right < nums.length; right++) {

            // Update condition
            if(nums[right] == 0){
                zeros++;
            }

            // Shrink window if invalid
            while (zeros > k) {

                // Update condition
                if(nums[left] == 0){
                    zeros--;
                }

                left++;
            }

            longest = Math.max(longest, right-left);

            // Update answer
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,0,1};

        int k = 1;

        int result = longestOnes(nums, k);

        System.out.println(result);
    }
}