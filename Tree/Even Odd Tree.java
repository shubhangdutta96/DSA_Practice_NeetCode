class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int nextForEven = -1;
            int nextForOdd = Integer.MAX_VALUE;
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();

                if(level%2 == 0) {
                    if(curr.val%2 == 0 || curr.val <= nextForEven) {
                        return false;
                    }
                    nextForEven = curr.val;
                } else {
                    if(curr.val%2 != 0 || curr.val >= nextForOdd) {
                        return false;
                    }
                    nextForOdd = curr.val;
                }

                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            level++;
        }

        return true;
    }
}
