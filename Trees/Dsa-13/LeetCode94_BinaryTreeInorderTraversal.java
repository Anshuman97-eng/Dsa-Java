// LeetCode 94 - Binary Tree Inorder Traversal
import java.util.*;

class LeetCode94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if(node == null){
            return;
        }

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // Build sample tree: [1,null,2,3]
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        LeetCode94_BinaryTreeInorderTraversal sol = new LeetCode94_BinaryTreeInorderTraversal();
        System.out.println(sol.inorderTraversal(root)); // Output: [1,3,2]
    }
}

// TreeNode definition (same as LeetCode)
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
