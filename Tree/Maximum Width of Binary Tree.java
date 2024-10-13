class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair(root, 1));

        while(!q.isEmpty()) {
            int size = q.size();
            int min = 0;
            int max = 0;

            for(int i=0; i<size; i++) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode curr = p.getKey();
                int idx = p.getValue();

                if(i == 0) {
                    min = idx;
                }
                if(i == size-1) {
                    max = idx;
                }


                if(curr.left != null) {
                    q.offer(new Pair(curr.left, 2*idx));
                }
                
                if(curr.right != null) {
                    q.offer(new Pair(curr.right, 2*idx+1));
                }
            }

            ans = Math.max(ans, max-min+1);
        }

        return ans;
    }
}
