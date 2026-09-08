import java.util.*;

class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 👉 You will write the logic here
        Arrays.sort(candidates);
        List<List<Integer>> result  = new ArrayList<>();
        solve(candidates,0,target,result,new ArrayList<Integer>());
        return result; // temporary return
    }

    public static  void solve(int[] nums,int idx , int target, List<List<Integer>> result,List<Integer> curr){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(idx == nums.length){
            return;
        }
        for(int i=idx; i<nums.length ; i++){  
            if(i > idx && nums[i-1] == nums[i]){
                continue;
            }

            curr.add(nums[i]);
            solve(nums, i+1, target-nums[i], result, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = obj.combinationSum2(candidates, target);
        System.out.println("Combinations = " + result);
    }
}
