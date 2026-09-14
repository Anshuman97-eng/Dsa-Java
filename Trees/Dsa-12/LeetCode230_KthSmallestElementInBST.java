
import java.util.*;

// LeetCode 230 - Kth Smallest Element in a BST
class LeetCode230_KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result.get(k - 1); // k-th smallest value
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
        // Build sample tree: [3,1,4,null,2]
        TreeNode root = new TreeNode(3,
            new TreeNode(1, null, new TreeNode(2)),
            new TreeNode(4)
        );

        LeetCode230_KthSmallestElementInBST sol = new LeetCode230_KthSmallestElementInBST();
        System.out.println(sol.kthSmallest(root, 1)); // Output: 1
        System.out.println(sol.kthSmallest(root, 2)); // Output: 2
        System.out.println(sol.kthSmallest(root, 3)); // Output: 3
        System.out.println(sol.kthSmallest(root, 4)); // Output: 4
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
