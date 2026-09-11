// LeetCode 543. Diameter of Binary Tree

class DiameterOfBinaryTree {
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    int diameter = 0; // global tracker

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if(node == null){
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        diameter = Math.max(diameter,left + right);
        return 1 + Math.max(left,right);
    }
    public static void main(String[] args) {
        // sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        System.out.println(sol.diameterOfBinaryTree(root)); // expected output: 3
    }
}
