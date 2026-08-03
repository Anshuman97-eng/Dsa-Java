// Running Product Pattern (Maximum Product Subarray)

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];

        for(int i=1 ; i<nums.length ; i++){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};

        int result = maxProduct(nums);

        System.out.println("Maximum Product: " + result);
    }
}