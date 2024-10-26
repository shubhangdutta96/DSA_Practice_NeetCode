class BSTIterator {
    List<Integer> inOrder = new ArrayList<>();
    int i;

    public BSTIterator(TreeNode root) {
        i = 0;
        in_order(root);
    }
    
    public int next() {
        int ans = inOrder.get(i);
        i++;

        return ans;
    }
    
    public boolean hasNext() {
        return i < inOrder.size();
    }

    public void in_order(TreeNode root) {
        if(root == null) {
            return;
        }

        in_order(root.left);
        inOrder.add(root.val);
        in_order(root.right);

        return;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
