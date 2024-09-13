class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = Integer.MIN_VALUE;
        solve(root);

        return res-1;
    }

    public int solve(TreeNode root) {
        // base case
        if(root == null) {
            return 0;
        }

        // hypothesis
        int left = solve(root.left);
        int right = solve(root.right);

        // induction
        int temp = Math.max(left, right) + 1; 
        // Passing through the Root node 
        
        int ans = 1 + left + right; 
        // Not passing through the Root node

        res = Math.max(res, Math.max(temp, ans));

        return temp;
    }
}
