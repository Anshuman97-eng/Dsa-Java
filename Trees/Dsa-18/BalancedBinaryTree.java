// LeetCode 110 - Balanced Binary Tree
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1; // left subtree not balanced

        int right = checkHeight(node.right);
        if (right == -1) return -1; // right subtree not balanced

        if (Math.abs(left - right) > 1) return -1; // current node not balanced

        return 1 + Math.max(left, right); // ✅ use stored values
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // Example 1: Balanced tree
        TreeNode root1 = new TreeNode(1,
            new TreeNode(2),
            new TreeNode(3)
        );

        // Example 2: Unbalanced tree
        TreeNode root2 = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), null),
            null
        );

        BalancedBinaryTree sol = new BalancedBinaryTree();
        System.out.println(sol.isBalanced(root1)); // Expected: true
        System.out.println(sol.isBalanced(root2)); // Expected: false
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
