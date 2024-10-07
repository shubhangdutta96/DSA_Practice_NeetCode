class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        if(root.val > val) {
            root.left = insertion(root.left, val);
        }
        else {
            root.right = insertion(root.right, val);
        }

        return root;
    }

    public TreeNode insertion(TreeNode root, int val) {
        if(root == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }

        if(root.val > val) {
            root.left = insertion(root.left, val);
        }
        else {
            root.right = insertion(root.right, val);
        }

        return root;
    }
}
