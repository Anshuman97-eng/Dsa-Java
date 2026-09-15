// LeetCode 145 - Binary Tree Postorder Traversal
import java.util.*;

class LeetCode145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        func(result,root);
        return result;
    }


    public  void func(List<Integer> result,TreeNode root){
        if(root == null){
            return;
        }

        func(result, root.left);
        func(result,root.right);
        result.add(root.val);
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // Example tree: [1,null,2,3]
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        LeetCode145_BinaryTreePostorderTraversal sol = new LeetCode145_BinaryTreePostorderTraversal();
        System.out.println(sol.postorderTraversal(root)); 
        // Expected Output: [3, 2, 1]
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
