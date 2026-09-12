// LeetCode 103. Binary Tree Zigzag Level Order Traversal (Recursive)

import java.util.*;

class ZigzagLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private void func(TreeNode root, int level) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while(!queue.isEmpty()){

            int size = queue.size();
            LinkedList<Integer> curr = new LinkedList<>();

            for(int i=0 ; i<size ; i++){
                TreeNode node = queue.poll();
                if(flag){
                    curr.addLast(node.val);
                }else{
                    curr.addFirst(node.val);
                }

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            System.out.println(curr); 
            flag = !flag;
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

        ZigzagLevelOrderTraversal sol = new ZigzagLevelOrderTraversal();
        sol.func(root,0);
        // expected output: [[3], [20, 9], [15, 7]]
    }
}
