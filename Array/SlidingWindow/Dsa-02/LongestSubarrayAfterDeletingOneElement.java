// Pattern: Sliding Window
// Question: Longest Subarray of 1's After Deleting One Element
//
// Explanation:
// Given a binary array,
// delete exactly one element.
//
// Find the longest consecutive
// sequence of 1's after deletion.

public class LongestSubarrayAfterDeletingOneElement {

    public static int longestSubarray(int[] nums) {

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
            while (zeros > 1) {
                if(nums[left] == 0 ){
                    zeros--;
                }
                // Update condition
                left++;
            }

            // Update answer
            longest = Math.max(longest, right - left);
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,1,0,1};

        int result = longestSubarray(nums);

        System.out.println(result);
    }
}