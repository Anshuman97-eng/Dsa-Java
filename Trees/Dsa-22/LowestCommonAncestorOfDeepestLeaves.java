import java.util.*;

class LowestCommonAncestorOfDeepestLeaves {
    Map<TreeNode, Integer> depthMap = new HashMap<>();
    int maxDepth = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // Step 1: DFS to fill map and find maxDepth
        dfs(root, 0);

        // Step 2: Use LCA function on deepest nodes
        return lca(root);
    }

    // DFS to record depth of each node
    private void dfs(TreeNode node, int depth) {
        if(node == null){
            return;
        }

        maxDepth = Math.max(maxDepth,depth);
        depthMap.put(node,depth);

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    // LCA logic: return node if it's deepest or split point
    private TreeNode lca(TreeNode root) {
        if(root == null){
            return root;
        }

        int depth = depthMap.get(root);

        if(depth == maxDepth){
            return root;
        }
        
        TreeNode left = lca(root.left);
        TreeNode right = lca(root.right);

        if(left != null && right != null){
            return  root;
        }

        return left != null ? left : right;
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        // Example tree:
        //        1
        //       / \
        //      2   3
        //     /
        //    4

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        LowestCommonAncestorOfDeepestLeaves sol = new LowestCommonAncestorOfDeepestLeaves();
        System.out.println(sol.lcaDeepestLeaves(root).val); 
        // Deepest leaves = 4 and 3 → LCA = 1
    }
}

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
