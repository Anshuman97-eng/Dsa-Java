// Height of Tree
class HeightOfTree {
    public int height(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // Example tree:
        //       3
        //      / \
        //     9   20
        //         / \
        //        15  7
        TreeNode root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        HeightOfTree sol = new HeightOfTree();
        System.out.println(sol.height(root)); 
        // Expected Output: 3
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
