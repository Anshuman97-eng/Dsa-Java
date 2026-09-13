// LeetCode 144. Binary Tree Preorder Traversal

import java.util.*;

class BinaryTreePreorderTraversal {
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

    // 👉 Preorder Traversal function
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if(node == null){
            return;
        }
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public static void main(String[] args) {
        // 👉 Build a sample tree to test
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreePreorderTraversal sol = new BinaryTreePreorderTraversal();
        System.out.println(sol.preorderTraversal(root));
        // Expected output: [1, 2, 4, 5, 3]
    }
}
