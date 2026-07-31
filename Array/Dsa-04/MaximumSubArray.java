
//Running Sum Pattern (Kadane's Algorithm)
public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int countmax = 0;

        for(int i=0 ; i<nums.length ; i++){
            countmax += nums[i];
            maxSum = Math.max(countmax, maxSum);


            // main functionality ...
            if(countmax < 0){
                countmax = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}