/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res;
    public int maxPathSum(TreeNode root) {
        if(root.right == null && root.left == null) {
            return root.val;
        }
        res = Integer.MIN_VALUE;
        solve(root);

        return res;
    }

    public int solve(TreeNode root) {
        // base case 
        if(root == null) {
            return 0;
        }

        // hypothesis
        int l = solve(root.left);
        int r = solve(root.right);

        // induction
        int temp = Math.max(root.val + Math.max(l, r), root.val);
        int ans = Math.max(temp, root.val+l+r);
        res = Math.max(res, Math.max(temp, ans));

        return temp;
    }
}
