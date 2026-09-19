import java.util.*;

// Definition for a binary tree node

class KthSmallestElement {
    public int kthSmallest(TreeNode root, int k) {
        // Step 1: Create a list to store inorder traversal
        List<Integer> inorderList = new ArrayList<>();

        // Step 2: Fill list using inorder traversal
        inorder(root, inorderList);

        // Step 3: Return kth element (list is 0-indexed)
        return inorderList.get(k - 1);
    }

    // Helper function for inorder traversal
    private void inorder(TreeNode node, List<Integer> list) {
        if(node == null){
            return ;
        }

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    // Main method to test
    public static void main(String[] args) {
        // Build example BST: [3,1,4,null,2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElement obj = new KthSmallestElement();
        int k = 2;

        int result = obj.kthSmallest(root, k);
        System.out.println("Kth smallest element = " + result);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}