import java.util.HashMap;

/*
 * Problem Name : Continuous Subarray Sum (LeetCode 523)
 *
 * Pattern Used : Prefix Sum + HashMap (Remainder)
 *
 * Input  : int[] nums, int k
 * Output : boolean
 *
 * Definition:
 * Return true if there exists a continuous subarray
 * of length >= 2 whose sum is divisible by k.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum =0;
        int remainder = 0;

        for(int i=0 ; i<nums.length ; i++){
            prefixSum += nums[i];
            remainder = prefixSum % k;

            if(map.containsKey(remainder)){
                if(i - map.get(remainder) >= 2){
                    return true;
                }
            }else{
                map.put(remainder,i);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;

        boolean answer = checkSubarraySum(nums, k);

        System.out.println(answer);
    }
}