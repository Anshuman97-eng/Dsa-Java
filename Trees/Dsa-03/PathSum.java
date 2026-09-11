// LeetCode 112. Path Sum

class PathSum {
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Function to check if a path sum exists
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        // sample tree:
        //       5
        //      / \
        //     4   8
        //    /   / \
        //   11  13  4
        //  /  \
        // 7    2

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        PathSum sol = new PathSum();
        System.out.println(sol.hasPathSum(root, 22)); // expected output: true
    }
}
