// Definition for a binary tree node
import java.util.*;

public class Codec {

    // 👉 Serialize: tree → string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // 👉 Deserialize: string → tree
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q) {
        String s = q.poll();
        if (s == null || s.trim().equals("null") || s.trim().isEmpty()) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s.trim()));
        node.left = buildTree(q);
        node.right = buildTree(q);
        return node;
    }

    // 👉 Test main
    public static void main(String[] args) {
        // Build a sample tree: 1 -> (2, 3)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String data = ser.serialize(root);
        System.out.println("Serialized: " + data);

        TreeNode ans = deser.deserialize(data);
        System.out.println("Deserialized root value: " + ans.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
