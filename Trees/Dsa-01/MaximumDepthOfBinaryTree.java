// LeetCode 104. Maximum Depth of Binary Tree

class MaximumDepthOfBinaryTree {
    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left,right);
    }

    public static void main(String[] args) {
        // sample tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
        int depth = sol.maxDepth(root);
        System.out.println(depth); // expected output: 3
    }
}
