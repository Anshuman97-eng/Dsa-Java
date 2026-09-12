// LeetCode 102. Binary Tree Level Order Traversal (Recursive)

import java.util.*;

class LevelOrderTraversalRecursive {
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Main function
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            for(TreeNode node : queue){
                System.out.print("[" + node.val  + "]");
            }
            
            int size = queue.size();
            for(int i=0 ; i<size ; i++){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.add(
                        node.left
                    );
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

    }

    public static void main(String[] args) {
        // sample tree:
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversalRecursive sol = new LevelOrderTraversalRecursive();
        sol.levelOrder(root);
    }
}
