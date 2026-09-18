// LeetCode 124 - Binary Tree Maximum Path Sum
public class MaxPathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if(node == null){
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int currSum = Math.max(left, right) + node.val;
        maxSum = Math.max(currSum,maxSum);

        return  node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        MaxPathSum obj = new MaxPathSum();

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Path Sum = " + obj.maxPathSum(root));
    }
}
