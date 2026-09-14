// LeetCode 98 - Validate Binary Search Tree
public class LeetCode98_ValidateBinarySearchTree {
    private Integer prev = null; // keeps track of last visited value

    public boolean isValidBST(TreeNode root) {
        return inorderCheck(root);
    }

    private boolean inorderCheck(TreeNode node) {
        if(node == null){
            return true;
        }

        if(!inorderCheck(node.left)){
            return false;
        }

        if(prev != null && node.val <= prev ){
            return  false;
        }

        prev = node.val;

        return inorderCheck(node.right);
    }

    public static void main(String[] args) {
        // Build a sample tree: [2,1,3]
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        LeetCode98_ValidateBinarySearchTree sol = new LeetCode98_ValidateBinarySearchTree();
        System.out.println(sol.isValidBST(root)); // true
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
