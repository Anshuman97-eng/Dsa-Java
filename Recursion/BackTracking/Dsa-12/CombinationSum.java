import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // your code here
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] candidates, int target, int idx) {
        // your recursion code here

        if(idx == candidates.length || target < 0){
            return; 
        }

        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(candidates[idx]);
        backtrack(result, curr, candidates, target - candidates[idx], idx);

        curr.remove(curr.size() - 1);
        backtrack(result, curr, candidates, target, idx + 1);
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = cs.combinationSum(candidates, target);
        System.out.println(ans);
    }
}
