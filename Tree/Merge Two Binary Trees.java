class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();

        if(root1 == null && root2 == null) {
            return null;
        }   
        if(root1 == null) {
            return root2;
        }
        else if(root2 == null) {
            return root1;
        }
        else {
            root.val = root1.val + root2.val;
        }

        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }
}
