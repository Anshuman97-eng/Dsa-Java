// LeetCode 236 - Lowest Common Ancestor of a Binary Tree
class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // Build sample tree:
        //        3
        //       / \
        //      5   1
        //     / \  / \
        //    6  2 0   8
        //      / \
        //     7   4

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestorOfBinaryTree sol = new LowestCommonAncestorOfBinaryTree();

        // Example tests
        System.out.println(sol.lowestCommonAncestor(root, root.left.right.left, root.left.right.right).val); // LCA(7,4) → 2
        System.out.println(sol.lowestCommonAncestor(root, root.left.left, root.right.right).val); // LCA(6,8) → 3
    }
}

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
