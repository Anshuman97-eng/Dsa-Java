/*
 * Problem Name : Jump Game II (LeetCode 45)
 *
 * Pattern Used : Greedy
 *
 * Input  : int[] nums
 * Output : int
 *
 * Definition:
 * Return the minimum number of jumps
 * required to reach the last index.
 *
 * Note:
 * You can always assume that you can reach the last index.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 */

public class JumpGameII {

    public static int jump(int[] nums) {

        int left =0;
        int right =0;
        int jump = 0;
        int max = 0;

        while(right < nums.length-1){
            for(int i=left ; i<=right ; i++){
                max = Math.max(max,left + nums[i]);
            }
            left = right+1;
            right = max;
            jump++;
        }

        return jump;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        int result = jump(nums);

        System.out.println(result);
    }
}