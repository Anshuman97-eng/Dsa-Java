// LeetCode 257. Binary Tree Paths

import java.util.*;

class BinaryTreePaths {
    // Definition for a binary tree node
    public static class TreeNode {
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

    // 👉 Function to collect all root-to-leaf paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;


        if (node.left == null && node.right == null) {
            result.add(path + node.val); // ✅ add full path
        } else {
            dfs(node.left, path + node.val + "->", result);
            dfs(node.right, path + node.val + "->", result); // ✅ right child
        }

    }

    public static void main(String[] args) {
        // 👉 Build a sample tree to test
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths sol = new BinaryTreePaths();
        System.out.println(sol.binaryTreePaths(root));
        // Expected output: [1->2->5, 1->3]
    }
}
