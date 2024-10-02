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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        return solve(root, targetSum, 0);
    }

    public boolean solve(TreeNode root, int targetSum, int sum) {
        if(root == null) {
            return false;
        }

        sum += root.val;

        // check for the Leaf Node
        if(root.left == null && root.right == null) {
            if(sum == targetSum) {
                return true;
            }
        }

        return solve(root.left, targetSum, sum) ||
                solve(root.right, targetSum, sum);
    }
}
