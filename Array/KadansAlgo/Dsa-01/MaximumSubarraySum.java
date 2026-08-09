

/*
 * Problem : Maximum Subarray Sum (LeetCode 53)
 *
 * Pattern : Kadane's Algorithm
 *
 * Input  : int[] nums
 * Output : int
 *
 * Definition:
 * Find the maximum sum of a continuous subarray.
 *
 * Example:
 * nums = [-2,1,-3,4,-1,2,1,-5,4]
 *
 * Best subarray = [4,-1,2,1]
 * Answer = 6
 *
 * Idea:
 * currentSum = best sum ending at current element.
 *
 * At every element:
 * Start new OR continue previous subarray.
 *
 * Time  : O(n)
 * Space : O(1)
 */

public class MaximumSubarraySum {

    public static int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Start new or continue
            currentSum = Math.max(
                nums[i],
                currentSum + nums[i]
            );

            // Update maximum answer
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {
            -2, 1, -3, 4, -1, 2, 1, -5, 4
        };

        int result = maxSubArray(nums);

        System.out.println(result);
    }
}