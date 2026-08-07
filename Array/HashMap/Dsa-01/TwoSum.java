import java.util.HashMap;

/*
 * Problem Name : Two Sum (LeetCode 1)
 *
 * Pattern Used : HashMap
 *
 * Input  : int[] nums, int target
 * Output : int[]
 *
 * Definition:
 * Return the indices of the two numbers
 * whose sum is equal to the target.
 *
 * You may assume that exactly one solution exists.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        // Create a HashMap to store (number, index)
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Find the required number
            int complement = target - nums[i];

            // If the complement is already in the map,
            // we found the answer
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store the current number and its index
            map.put(nums[i], i);
        }

        // No solution found
        return new int[] {};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}