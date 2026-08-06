/*
 * Problem Name : Jump Game (LeetCode 55)
 *
 * Pattern Used : Greedy
 *
 * Input  : int[] nums
 * Output : boolean
 *
 * Definition:
 * Return true if you can reach the last index,
 * otherwise return false.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 */

public class JumpGame {

    public static boolean canJump(int[] nums) {

        // Your code here
        int n = nums.length;
        int goal = n-1;

        for(int i=n-2 ; i>=0 ; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }

        }

        return goal == 0;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        boolean result = canJump(nums);

        System.out.println(result);
    }
}