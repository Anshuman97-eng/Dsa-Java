import java.util.Arrays;

/*
 * Problem Name : Product of Array Except Self (LeetCode 238)
 *
 * Pattern Used : Prefix Product + Suffix Product
 *
 * Input  : int[] nums
 * Output : int[]
 *
 * Definition:
 * Return an array where each element is the product
 * of all the elements except itself.
 *
 * Note:
 * - Do not use division.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answer = new int[n];

        prefix[0] = 1;
        for(int i=1 ; i<nums.length ; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        suffix[n-1] = 1;
        for(int i=n-2 ; i>=0 ; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i=0 ; i<nums.length ; i++){
            answer[i] = prefix[i] * suffix[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] answer = productExceptSelf(nums);

        System.out.println(Arrays.toString(answer));
    }
}