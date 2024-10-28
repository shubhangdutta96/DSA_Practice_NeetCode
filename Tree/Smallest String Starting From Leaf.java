class Solution {
    public String smallestFromLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();

        dfs(root, list, new StringBuilder(""));

        Collections.sort(list);
        return list.isEmpty() ? "" : list.get(0);
    }

    public void dfs(TreeNode root, List<String> list, StringBuilder str) {
        if(root == null) {
            return;
        }

        str.insert(0, (char)('a'+root.val));

        dfs(root.left, list, str);
        dfs(root.right, list, str);

        if(root.left == null && root.right == null) {
            list.add(str.toString());
        }

        str.deleteCharAt(0);

        return;
    }
}
