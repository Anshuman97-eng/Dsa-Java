import java.util.HashSet;

/*
 * Problem Name : Longest Consecutive Sequence (LeetCode 128)
 *
 * Pattern Used : HashSet
 *
 * Input  : int[] nums
 * Output : int
 *
 * Definition:
 * Return the length of the longest consecutive
 * elements sequence in an unsorted array.
 *
 * Hint:
 *
 * 1. Store all numbers in HashSet.
 *
 * 2. Find the starting number:
 *    If (num - 1) is not present,
 *    then num is the start of a sequence.
 *
 * 3. Count:
 *    num, num+1, num+2...
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        // Store all numbers in HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Check every number
        for (int num : set) {

            // Check if it is the starting number
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                // Update maximum length
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println(result);
    }
}