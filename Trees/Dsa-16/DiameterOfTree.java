// Diameter of Tree
class DiameterOfTree {
    int diameter = 0;
    public int diameter(TreeNode root) {
        if(root == null){
            return  0;
        }

        int left = diameter(root.left);
        int right = diameter(root.right);

        diameter = Math.max(diameter,left + right);

        return 1 + Math.max(left,right);
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // Example tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3)
        );

        DiameterOfTree sol = new DiameterOfTree();
        System.out.println(sol.diameter(root)); 
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
