import java.util.*;


// Need → Check → Store → Return ✅
public class TwoSum {

    // Complete this method
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0 ; i<nums.length ; i++){
            int value = target - nums[i];

            if(map.containsKey(value)){
                System.out.println("Point Found : " + nums[i]);
                return new int[]{map.get(value),i};
            }

            map.put(nums[i],i);
        }


        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}