class Solution {
    boolean ans;
    public boolean isSubPath(ListNode head, TreeNode root) {

        ans = false;

        traversal(root, head);

        return ans;
    }

    public void traversal(TreeNode root, ListNode curr) {

        if(root == null) {
            return;
        }

        
        if(root.val == curr.val) {

            if(solve(root, curr)) {
                ans = true;
                return; 
            }
        }
        
        traversal(root.left, curr);
        traversal(root.right,curr);
    }

    public boolean solve(TreeNode root, ListNode curr) {

        if(curr == null) {
            return true;
        }

        if(root == null) {
            return false;
        }

        if(root.val != curr.val){
            return false;
        }

        return solve(root.left, curr.next) || solve(root.right, curr.next);
    }
}
