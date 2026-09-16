// LeetCode 235 - Lowest Common Ancestor of a Binary Search Tree
class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p){
            return root;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);   // go left
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);  // go right
        } else {
            return root; // split → LCA
        }

    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // Build sample BST:
        //        6
        //       / \
        //      2   8
        //     / \  / \
        //    0  4 7   9
        //      / \
        //     3   5

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        LowestCommonAncestorOfBST sol = new LowestCommonAncestorOfBST();

        // Example tests
        System.out.println(sol.lowestCommonAncestor(root, root.left, root.right).val); // LCA(2,8) → 6
        System.out.println(sol.lowestCommonAncestor(root, root.left, root.left.right).val); // LCA(2,4) → 2
        System.out.println(sol.lowestCommonAncestor(root, root.left.right.left, root.left.right.right).val); // LCA(3,5) → 4
    }
}

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
