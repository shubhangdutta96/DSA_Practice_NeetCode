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
    public int rob(TreeNode root) {
        int ans[] = dfs(root);

        return Math.max(ans[0], ans[1]);
    }

    public int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[2];
        }

        int leftSubTree[] = dfs(root.left);
        int rightSubTree[] = dfs(root.right);

        int includeRoot = root.val + leftSubTree[1] + rightSubTree[1];
        int excludeRoot = Math.max(leftSubTree[0], leftSubTree[1]) +  
                        Math.max(rightSubTree[0], rightSubTree[1]);

        return new int[] {includeRoot, excludeRoot};
    }
}
