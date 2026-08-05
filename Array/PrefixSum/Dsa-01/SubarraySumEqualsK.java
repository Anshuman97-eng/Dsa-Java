// Pattern: Prefix Sum + HashMap
// Question: Subarray Sum Equals K
//
// Explanation:
// Given an integer array and an integer k,
// find the number of continuous
// subarrays whose sum is equal to k.

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        // Prefix Sum -> Frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initialize variables
        int prefixSum = 0;
        int count = 0;

        // Initial prefix sum
        map.put(0, 1);

        // Traverse the array
        for (int num : nums) {

            // Update Prefix Sum
            prefixSum += num;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            // Check if required Prefix Sum exists

            // Update Answer
            map.put(prefixSum,  map.getOrDefault(prefixSum, 0) + 1);

            // Store current Prefix Sum
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        int k = 3;

        int result = subarraySum(nums, k);

        System.out.println(result);
    }
}