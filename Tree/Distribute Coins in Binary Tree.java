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
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[2];
        }

        int left[] = dfs(root.left);
        int right[] = dfs(root.right);

        int size = 1 + left[0] + right[0];
        int coins = root.val + left[1] + right[1];

        ans += Math.abs(coins - size);

        return new int[]{size, coins};
    }
}
