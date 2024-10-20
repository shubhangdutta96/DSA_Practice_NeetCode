class Solution {
    int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        helper(root, 0);

        return ans;
    }

    public void helper(TreeNode root, int curr) {
        if(root == null) {
            return;
        }

        int next = (curr+root.val);
        if(root.left == null && root.right ==null) {
            ans += next;
        }

        helper(root.left, next*10);
        helper(root.right, next*10);

        return;
    }
}
