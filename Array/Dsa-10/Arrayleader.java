// Maximum From Right Pattern (Array Leaders)

import java.util.*;

public class Arrayleader {

    public static List<Integer> leaders(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int max = nums[nums.length - 1];
 

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                ans.add(max);
            }
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = { 16, 17, 4, 3, 5, 2 };

        List<Integer> result = leaders(nums);

        System.out.println(result);
    }
}