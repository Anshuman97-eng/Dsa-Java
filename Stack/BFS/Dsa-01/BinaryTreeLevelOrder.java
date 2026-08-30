import java.util.*;

class BinaryTreeLevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // 👉 add node.val to level
                level.add(node.val);
                
                // 👉 if node.left != null → q.add(node.left)
                if(node.left != null){
                    q.add(node.left);
                }

                // 👉 if node.right != null → q.add(node.right)
                if(node.right != null){
                    q.add(node.right);
                }
            }

            result.add(level);
            // 👉 add level to result
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = levelOrder(root);
        System.out.println(ans);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
