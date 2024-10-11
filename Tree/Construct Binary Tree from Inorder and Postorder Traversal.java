class Solution {
    int i;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = postorder.length-1;
        i = postorder.length-1;

        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(map, postorder, 0, n);
    }

    public TreeNode helper(Map<Integer, Integer> map, int[] postorder, 
    int start, int end) {
        if(start > end) {
            return null;
        }
        
        int rootValue = postorder[i--];
        TreeNode root = new TreeNode(rootValue);

        int inOrderIndex = map.get(rootValue);

        root.right = helper(map, postorder, inOrderIndex+1, end);
        root.left = helper(map, postorder, start, inOrderIndex-1);

        return root;
    }
}
