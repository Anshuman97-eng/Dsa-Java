// LeetCode 111 - Minimum Depth of Binary Tree
class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // Example tree: [2,3,null]
        TreeNode root = new TreeNode(2,
            new TreeNode(3), // left child
            null             // right child
        );

        MinimumDepthOfBinaryTree sol = new MinimumDepthOfBinaryTree();
        System.out.println(sol.minDepth(root)); 
        // Expected Output: 2
    }
}

// TreeNode definition
class TreeNode {
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
