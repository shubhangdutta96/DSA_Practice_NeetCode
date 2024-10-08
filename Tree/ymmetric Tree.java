class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) {
            return true;
        }
        else if(root.left == null || root.right == null) {
            return false;
        }

        return solve(root.left, root.right);
    }

    public boolean solve(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        else if(root1 == null || root2 == null) {
            return false;
        }

        if(root1.val != root2.val) {
            return false;
        }

        return solve(root1.left, root2.right) && 
        solve(root1.right, root2.left);

    }
}
