class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);

                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            list.add(max);
        }

        return list;
    }
}
