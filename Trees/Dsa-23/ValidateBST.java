// LeetCode 98 - Validate Binary Search Tree
class ValidateBST {
    private Integer prev = null; // use Integer, not int

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        // check left subtree
        if (!isValidBST(root.left)) return false;

        // check current node
        if (prev != null && root.val <= prev) return false;
        prev = root.val;

        // check right subtree
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        // Build sample tree: [2,1,3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBST obj = new ValidateBST();
        boolean result = obj.isValidBST(root);

        System.out.println("Is Valid BST? " + result); // should print true
    }
}

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
