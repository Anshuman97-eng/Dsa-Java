import java.util.HashSet;

/*
 * Problem Name : Contains Duplicate (LeetCode 217)
 *
 * Pattern Used : HashSet
 *
 * Input  : int[] nums
 * Output : boolean
 *
 * Definition:
 * Return true if any value appears at least twice
 * in the array, otherwise return false.
 *
 * Hint:
 *
 * HashSet stores only unique values.
 *
 * For every number:
 * 1. Check if the number already exists in Set.
 * 2. If yes -> duplicate found -> return true.
 * 3. If no -> add the number to Set.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }


        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        boolean result = containsDuplicate(nums);

        System.out.println(result);
    }
}