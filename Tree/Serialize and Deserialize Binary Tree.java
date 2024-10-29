/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    
    List<Integer> list = new ArrayList<>();

    public String serialize(TreeNode root) {
        preOrder(root);
        StringBuilder sb = new StringBuilder("");

        for(int num : list) {
            sb.append(num).append(",");
        }

        return sb.toString();
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            list.add(-1001);
            return;   
        }

        list.add(root.val);

        preOrder(root.left);
        preOrder(root.right);

        return;
    }

    // Decodes your encoded data to tree.
    
    public TreeNode deserialize(String data) {
        Queue<Integer> q = new LinkedList<>();
        char ch[] = data.toCharArray();

        for (String str : data.split(",")) {
            if (!str.isEmpty()) { 
                q.offer(Integer.parseInt(str));
            }
        }

        return helper(q);
    }

    public TreeNode helper(Queue<Integer> q) {
        if(q.isEmpty()) {
            return null;
        }

        int num = q.poll();
        if(num == -1001) {
            return null;
        }
        
        TreeNode root = new TreeNode(num);

        root.left = helper(q);
        root.right = helper(q);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
