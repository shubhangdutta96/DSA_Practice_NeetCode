class Solution {
    int min = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        solve(root);

        return min;
    }

    public void solve(TreeNode root) {
        if(root == null) {
            return;
        }

        solve(root.left);
        min = Math.min(min, Math.abs(prev - root.val));
        prev = root.val;
        solve(root.right);

        return;
    }
}
