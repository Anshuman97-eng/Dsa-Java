 /*
  * Problem : Maximum Sum Subarray of Size K
  *
  * Pattern : Sliding Window
  *
  * Input  : int[] nums, int k
  * Output : int
  *
  * Definition:
  * Find the maximum sum of a continuous
  * subarray containing exactly k elements.
  *
  * Example:
  * nums = [2,1,5,1,3,2]
  * k = 3
  *
  * Answer = 9
  *
  * Pattern:
  *
  * 1. Add the current element.
  * 2. If window becomes bigger than k,
  *    remove the element leaving the window.
  * 3. When window size becomes k,
  *    update maximum sum.
  *
  * Formula:
  *
  * windowSum = windowSum + newElement
  * windowSum = windowSum - oldElement
  *
  * Time  : O(n)
  * Space : O(1)
  */

public class MaximumSumSubarray {

    public static int maxSum(int[] nums, int k) {

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Your code here

        for(int i=0 ; i<nums.length ; i++){
            windowSum += nums[i];

            if(i >= k){
                windowSum -= nums[i - k];
            }

            if(i >= k-1){
                maxSum = Math.max(maxSum, windowSum);
            }
        }



        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maxSum(nums, k);

        System.out.println(result);
    }
}