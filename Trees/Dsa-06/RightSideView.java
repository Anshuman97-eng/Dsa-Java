// LeetCode 199. Binary Tree Right Side View

import java.util.*;

class RightSideView {
    // Definition for a binary tree node.
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

    public List<Integer> rightSideView(TreeNode root) {
        // 👉 Your BFS/DFS logic goes here
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                TreeNode curr = q.poll();

                if(i == size - 1){
                    result.add(curr.val);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null)  q.add(curr.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 👉 You can build a sample tree here to test
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        RightSideView sol = new RightSideView();
        System.out.println(sol.rightSideView(root));
    }
}
