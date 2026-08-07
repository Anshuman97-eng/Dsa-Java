import java.util.HashMap;

/*
 * Problem Name : Subarray Sum Equals K (LeetCode 560)
 *
 * Pattern Used : Prefix Sum + HashMap
 *
 * Input  : int[] nums, int k
 * Output : int
 *
 * Definition:
 * Count the number of continuous subarrays
 * whose sum is exactly equal to k.
 *
 * Hint:
 *
 * Subarray Sum = Current Prefix Sum - Old Prefix Sum
 *
 * We need:
 * Current Prefix Sum - Old Prefix Sum = k
 *
 * Therefore:
 * Old Prefix Sum = Current Prefix Sum - k
 *
 * So we check:
 * map.containsKey(prefix - k)
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        int prefix = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store prefix sum 0 initially
        // It helps to find subarrays starting from index 0
        map.put(0, 1);

        for (int num : nums) {

            // Calculate current prefix sum
            prefix += num;

            // Check if required old prefix exists
            if (map.containsKey(prefix - k)) {

                count += map.get(prefix - k);
            }

            // Store current prefix sum frequency
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println(result);
    }
}