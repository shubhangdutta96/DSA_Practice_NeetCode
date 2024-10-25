class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int leftMostVal = root.val;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            leftMostVal = q.peek().val;

            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }

        return leftMostVal;
    }
}
