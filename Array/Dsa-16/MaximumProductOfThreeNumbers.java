import java.util.*;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        
        // Step 1: sort array
        Arrays.sort(nums);

        // Step 2: get length
        int n = nums.length;

        int product1 = nums[n-3] * nums[n-2] * nums[n-1];
        int product2 = nums[0] * nums[1] * nums[n-1];
        
        return Math.max(product1, product2);
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        MaximumProductOfThreeNumbers obj = new MaximumProductOfThreeNumbers();
        int[] nums = {1,2,3,4};
        System.out.println(obj.maximumProduct(nums)); // Expected output: 24
    }
}
