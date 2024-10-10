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
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        helper(map, root);
        return list;
    }

    public String helper(Map<String, Integer> map, TreeNode root) {
        if(root == null) {
            return "";
        }

        String left = helper(map, root.left);
        String right = helper(map, root.right);

        int val = root.val;

        String strFormed = val + "," + left + "," + right;

        if(map.getOrDefault(strFormed, 0) == 1) {
            // add duplicates only once not everytime it occurs
            list.add(root);
        }

        map.put(strFormed, map.getOrDefault(strFormed, 0)+1);

        return strFormed;
    }
}
