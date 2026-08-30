/*
 * Problem : Maximum Sum Circular Subarray (LeetCode 918)
 *
 * Pattern : Kadane's Algorithm
 *
 * Definition:
 * Find the maximum sum of a non-empty subarray
 * in a circular array.
 *
 * Example:
 * nums = {5, -3, 5}
 * Answer = 10
 *
 * Idea:
 *
 * 1. Find normal maximum subarray using Kadane.
 *
 * 2. Find minimum subarray using Kadane.
 *
 * 3. Find total sum.
 *
 * 4. Circular sum:
 *
 *    totalSum - minSum
 *
 * 5. Compare:
 *
 *    maxSum vs circularSum
 *
 * Important:
 * If all numbers are negative,
 * return maxSum directly.
 *
 * Time  : O(n)
 * Space : O(1)
 */

public class MaximumCircularSubarraySum {

    public static int maxSubarraySumCircular(int[] nums) {

        int circularSum;
        // Total array sum
        int totalSum = 0;

        // Maximum Kadane
        int currentMax = nums[0];
        int maxSum = nums[0];

        // Minimum Kadane
        int currentMin = nums[0];
        int minSum = nums[0];

        for(int i=0 ; i<nums.length ; i++){
            totalSum += nums[i];
            if(i > 0){
                currentMax = Math.max(nums[i], currentMax + nums[i]);
                maxSum = Math.max(maxSum, currentMax);

                currentMin = Math.min(nums[i], currentMin + nums[i]);
                minSum = Math.min(minSum, currentMin);
            }
        }


        // For the negative values answer
        if(maxSum < 0 ){
            return maxSum;
        }

        //formula for the circularSum ....
        circularSum = totalSum - minSum;





        return circularSum;
    }

    public static void main(String[] args) {

        int[] nums = {5, -3, 5};

        int result = maxSubarraySumCircular(nums);

        System.out.println(result);
    }
}