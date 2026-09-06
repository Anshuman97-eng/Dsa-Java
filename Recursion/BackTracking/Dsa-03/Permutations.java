import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);

        // print result
        for(List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // call recursion function here
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    // recursion function left empty for you
    private static void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // 👉 You will code this part yourself
        if(nums.length == current.size()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0 ; i<nums.length ; i++){
            if(used[i]){
                continue;
            }

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, current, used, result);

            used[i] = false;
            current.remove(current.size() - 1);
        }

    }
}
