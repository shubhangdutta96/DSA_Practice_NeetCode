class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        boolean flag = true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);

                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            if(!flag) {
                Collections.reverse(temp);
            }

            flag = !flag;
            ans.add(temp);
        }

        return ans;
    }
}
