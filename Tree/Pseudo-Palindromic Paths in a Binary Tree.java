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
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, new int[10]);

        return ans;
    }

    public void dfs(TreeNode root, int count[]) {
        if(root == null) {
            return;
        }

        count[root.val]++;

        dfs(root.left, count);
        dfs(root.right, count);

        if(root.left == null && root.right == null) {
            check(count);
        }

        count[root.val]--;

        return;
    }

    public void check(int count[]) {
        int countForOdd = 0;

        for(int val : count) {
            if(val%2 != 0) {
                countForOdd++;
            }
        }

        if(countForOdd <= 1) {
            ans++;
        }

        return;
    }
}
