import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates, 0, target, result, new ArrayList<>());
        return result;
    }

    public void backTrack(int[] nums, int idx, int target,
                          List<List<Integer>> result, List<Integer> curr) {
        // ✅ stop when index out of bounds OR target < 0
        if (idx == nums.length || target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(curr)); // ✅ copy list
            return;
        }

        // include (reuse allowed)
        curr.add(nums[idx]);
        backTrack(nums, idx, target - nums[idx], result, curr);
        curr.remove(curr.size() - 1);

        // exclude (skip to next index)
        backTrack(nums, idx + 1, target, result, curr);
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(obj.combinationSum(candidates, target));
        // ✅ Expected output: [[2,2,3], [7]]
    }
}
