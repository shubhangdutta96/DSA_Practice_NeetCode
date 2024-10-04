class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            if(root.val == 1) {
                return true;
            } 
            return false;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if(root.val == 2) {
            return left | right;
        }
        return left & right;
    }
}
