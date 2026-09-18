// LeetCode 112 - Path Sum
public class PathSum {

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // ✅ Path Sum function
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }

        int newTarget = targetSum - root.val;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        PathSum obj = new PathSum();

        // Example tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        // Test
        int target = 22;
        boolean result = obj.hasPathSum(root, target);

        System.out.println("Has Path Sum = " + result);
    }
}
