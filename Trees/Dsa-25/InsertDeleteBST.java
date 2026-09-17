// LeetCode 701 + 450 - Insert/Delete in BST
public class InsertDeleteBST {

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // ✅ Insert function
    public TreeNode insertNode(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    // ✅ Delete function
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found node to delete
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Two children → use predecessor (largest in left subtree)
            TreeNode curr = findMax(root.left);
            root.val = curr.val;
            root.left = deleteNode(root.left, curr.val);
        }
        return root;
    }

    // ✅ Find Max (largest in left subtree)
    public TreeNode findMax(TreeNode node) {
        while (node.right != null) node = node.right;
        return node;
    }

    // 🔹 Helper: Inorder traversal print
    public void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        InsertDeleteBST obj = new InsertDeleteBST();

        // Example tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        // Insert test
        root = obj.insertNode(root, 6);

        // Delete test
        root = obj.deleteNode(root, 7);

        // Print final tree inorder
        System.out.print("Final BST (inorder): ");
        obj.inorderPrint(root);
    }
}
