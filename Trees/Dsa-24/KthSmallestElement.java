// LeetCode 230 - Kth Smallest Element in a BST
class KthSmallestElement {
    int count;    // counter
    int result;   // answer

    public int kthSmallest(TreeNode root, int k) {
        count = 0;       // reset before each call
        result = -1;     // reset before each call
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return; // found kth, stop
        }

        inorder(node.right, k);
    }

    public static void main(String[] args) {
        // Example tree: [3,1,4,null,2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        KthSmallestElement obj = new KthSmallestElement();
        System.out.println("K=1 → " + obj.kthSmallest(root, 1)); // 1
        System.out.println("K=2 → " + obj.kthSmallest(root, 2)); // 2
        System.out.println("K=3 → " + obj.kthSmallest(root, 3)); // 3
        System.out.println("K=4 → " + obj.kthSmallest(root, 4)); // 4
    }
}

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
