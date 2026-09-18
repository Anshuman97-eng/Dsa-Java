// LeetCode 113 - Path Sum II
import java.util.*;

public class PathSumII {

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // ✅ Path Sum II function
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    // 🔹 DFS + Backtracking
    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> result) {
        if(node == null){
            return;
        }

        path.add(node.val);

        if(node.left == null && node.right == null && node.val == target){
            result.add(new ArrayList<>(path));
        }else{
            dfs(node.left, target - node.val, path, result);
            dfs(node.right, target - node.val, path, result);
        }

        path.remove(path.size() - 1);
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        PathSumII obj = new PathSumII();

        // Example tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        // Test
        int target = 22;
        List<List<Integer>> result = obj.pathSum(root, target);

        System.out.println("All Paths with Sum = " + target);
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
